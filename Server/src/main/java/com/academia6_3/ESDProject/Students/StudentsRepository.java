package com.academia6_3.ESDProject.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository
        extends JpaRepository<Students, Long> {

    //SELECT * FROM students WHERE email = email;
    //@Query("SELECT s FROM Students s WHERE s.email = ?1")
    Optional<Students> findStudentsByEmail(String email);
    Optional<Students> findStudentsByRollNo(Integer rollNo);
}
