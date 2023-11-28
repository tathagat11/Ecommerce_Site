package com.academia6_3.ESDProject.Bills;

import com.academia6_3.ESDProject.StudentPayment.StudentPayment;
import com.academia6_3.ESDProject.Students.Students;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bills {
    @Id
    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    @Column(name = "id")
    private Long billId;
    private String description;
    @Column(nullable = false)
    private Float amount;
    @Column(name = "bill_date", nullable = false)
    private LocalDate billDate;
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Students student;

    @JsonIgnore
    @OneToMany(mappedBy = "bills")
    private Set<StudentPayment> studentPaymentSet = new HashSet<>();


}
