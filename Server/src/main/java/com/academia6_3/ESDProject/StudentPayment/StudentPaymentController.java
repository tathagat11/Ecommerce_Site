package com.academia6_3.ESDProject.StudentPayment;

import com.academia6_3.ESDProject.OtherObjects.PaymentDTO;
import com.academia6_3.ESDProject.Students.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentpayments")
public class StudentPaymentController {
    private final StudentPaymentService studentPaymentService;

    @Autowired
    public StudentPaymentController(StudentPaymentService studentPaymentService) { this.studentPaymentService = studentPaymentService; }

    @PostMapping(path = "/addPayment")
    public void addPayments(@RequestBody PaymentDTO paymentDTO) {
        studentPaymentService.addPayments(paymentDTO);
    }

    @GetMapping(path = "/getpayments/{billId}")
    public ResponseEntity<List<StudentPayment>> getPayments(@PathVariable Long billId){
        return new ResponseEntity<>(studentPaymentService.getPayments(billId), HttpStatus.OK);
    }
}
