package com.academia6_3.ESDProject.StudentPayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPaymentRepository extends JpaRepository <StudentPayment, Long> {
    List<StudentPayment> findAllByBills_BillId(Long billId);
}
