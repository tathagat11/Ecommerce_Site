package com.academia6_3.ESDProject.Bills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BillsRepository extends JpaRepository <Bills, Long>{
    List<Bills> findAllByStudent_StudentId(Long studentId);
}
