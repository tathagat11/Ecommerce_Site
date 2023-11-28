package com.academia6_3.ESDProject.Students;

import com.academia6_3.ESDProject.Bills.Bills;
import com.academia6_3.ESDProject.StudentPayment.StudentPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName =  "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "roll_number")
    private Integer rollNo;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;

    private String email;
    @Column(name = "photograph_path")
    private String photographPath;
    private Float cgpa;
    @Column(name = "total_credits")
    private Integer credits;
    @Column(name = "graduation_year")
    private Integer gradYear;
    private String domain;
    private String specialisation;
    @Column(name = "placement_id")
    private Long placementId;

    @Column(name = "password")
    private String password;


    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Bills> bills = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "students")
    private Set<StudentPayment> studentPaymentSet = new HashSet<>();

    public Students() {
    }

    public Students(Long studentId, Integer rollNo, String fname, String lname, String email, String photographPath, Float cgpa, Integer credits, Integer gradYear, String domain, String specialisation, Long placementId, String password) {
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.credits = credits;
        this.gradYear = gradYear;
        this.domain = domain;
        this.specialisation = specialisation;
        this.placementId = placementId;
        this.password = password;
    }

    public Students(Integer rollNo, String fname, String lname, String email, String photographPath, Float cgpa, Integer credits, Integer gradYear, String domain, String specialisation, Long placementId, String password) {
        this.rollNo = rollNo;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.credits = credits;
        this.gradYear = gradYear;
        this.domain = domain;
        this.specialisation = specialisation;
        this.placementId = placementId;
        this.password = password;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getGradYear() {
        return gradYear;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Long placementId) {
        this.placementId = placementId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
