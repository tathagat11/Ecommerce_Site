package com.academia6_3.ESDProject.Bills;

import com.academia6_3.ESDProject.OtherObjects.BillsDTO;
import com.academia6_3.ESDProject.Students.Students;
import com.academia6_3.ESDProject.Students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillsService {
    private final BillsRepository billsRepository;
    private final StudentsRepository studentsRepository;

    @Autowired
    public  BillsService(BillsRepository billsRepository, StudentsRepository studentsRepository) {
        this.billsRepository = billsRepository;
        this.studentsRepository = studentsRepository;
    }

    public void addBills(BillsDTO billsDTO) {

        Bills bills = new Bills();
        bills.setDescription(billsDTO.getDescription());
        bills.setAmount(billsDTO.getAmount());
        bills.setBillDate(billsDTO.getBillDate());
        bills.setDeadline(billsDTO.getDeadline());
        Optional<Students> students = studentsRepository.findById(billsDTO.getStudentId());
        if(students.isPresent()){
            Students students1 = students.get();
            bills.setStudent(students1);
        }else {
            bills.setStudent(null);
        }
        billsRepository.save(bills);
    }

    public List<Bills> getBillsByRoll(Integer rollNo) {
        List<Bills> bills = new ArrayList<Bills>();
        Optional<Students> optionalStudents = studentsRepository.findStudentsByRollNo(rollNo);
        if(optionalStudents.isPresent()){
            Students student = optionalStudents.get();
            Long studentId = student.getStudentId();
            return billsRepository.findAllByStudent_StudentId(studentId);
        }
        else {
            return bills;
        }
    }
}
