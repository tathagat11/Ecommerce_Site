package com.academia6_3.ESDProject.StudentPayment;

import com.academia6_3.ESDProject.Bills.Bills;
import com.academia6_3.ESDProject.Students.Students;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_payment")
public class StudentPayment {
    @Id
    @SequenceGenerator(
            name = "studentpayment_sequence",
            sequenceName = "studentpayment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentpayment_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Students students;
    private String description;
    @Column(nullable = false)
    private Float amount;
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;


    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    private Bills bills;

    public StudentPayment() {
    }

    public StudentPayment(Long id, Students students, String description, Float amount, LocalDate paymentDate, Bills bills) {
        this.id = id;
        this.students = students;
        this.description = description;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.bills = bills;
    }

    public StudentPayment(Students students, String description, Float amount, LocalDate paymentDate, Bills bills) {
        this.students = students;
        this.description = description;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.bills = bills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Bills getBills() {
        return bills;
    }

    public void setBills(Bills bills) {
        this.bills = bills;
    }
}
