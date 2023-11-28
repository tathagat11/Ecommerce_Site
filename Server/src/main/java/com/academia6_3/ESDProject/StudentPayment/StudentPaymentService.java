package com.academia6_3.ESDProject.StudentPayment;

import com.academia6_3.ESDProject.Bills.Bills;
import com.academia6_3.ESDProject.Bills.BillsRepository;
import com.academia6_3.ESDProject.OtherObjects.PaymentDTO;
import com.academia6_3.ESDProject.Students.Students;
import com.academia6_3.ESDProject.Students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPaymentService {
    private final StudentPaymentRepository studentPaymentRepository;
    private final StudentsRepository studentsRepository;
    private final BillsRepository billsRepository;

    @Autowired
    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository, StudentsRepository studentsRepository, BillsRepository billsRepository) { this.studentPaymentRepository = studentPaymentRepository;
        this.studentsRepository = studentsRepository;
        this.billsRepository = billsRepository;
    }

    public void addPayments(PaymentDTO paymentDTO) {
        StudentPayment studentPayment = new StudentPayment();
        studentPayment.setDescription(paymentDTO.getDescription());
        studentPayment.setAmount(paymentDTO.getAmount());
        studentPayment.setPaymentDate(paymentDTO.getPaymentDate());
        Optional<Students> students = studentsRepository.findById(paymentDTO.getStudentId());
        if(students.isPresent()){
            Students students1 = students.get();
            studentPayment.setStudents(students1);
        } else {
            studentPayment.setStudents(null);
        }
        Optional<Bills> bills = billsRepository.findById(paymentDTO.getBillId());
        if(bills.isPresent()){
            Bills bills1 = bills.get();
            studentPayment.setBills(bills1);
        }
        studentPaymentRepository.save(studentPayment);
    }

    public List<StudentPayment> getPayments(Long billId) {
        return studentPaymentRepository.findAllByBills_BillId(billId);
    }
}
