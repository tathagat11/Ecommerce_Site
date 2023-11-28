package com.academia6_3.ESDProject.Students;

import com.academia6_3.ESDProject.OtherObjects.AuthObject;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Students> getStudents() {
        return studentsRepository.findAll();
    }

    public void addNewStudents(Students students) {
        Optional<Students> studentsOptional = studentsRepository.findStudentsByEmail(students.getEmail());
        if(studentsOptional.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        studentsRepository.save(students);
        System.out.println(students);
    }

    public void deleteStudents(Long studentId) {
        boolean exists = studentsRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with ID: " + studentId + " does not exist.");
        }
        studentsRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudents(Long studentId, String domain, Integer rollNo) {
        Students students = studentsRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with ID: " + studentId + " does not exist."));
        if(domain != null && !domain.isEmpty() && !Objects.equals(students.getDomain(), domain)) {
            students.setDomain(domain);
        }
        if(rollNo != null && rollNo>0 && rollNo < 500 && !Objects.equals(students.getRollNo(), rollNo)) {
            Optional<Students> optionalStudents = studentsRepository
                    .findStudentsByRollNo(rollNo);
            if(optionalStudents.isPresent()){
                throw new IllegalStateException("Roll number taken.");
            }
            students.setRollNo(rollNo);
        }
    }

    public boolean authenticate(AuthObject authObject) {
        Optional<Students> studentsOptional = studentsRepository.findStudentsByRollNo(authObject.getRollNo());
        if(studentsOptional.isPresent()){
            Students student = studentsOptional.get();
            return authObject.getPassword().equals(student.getPassword());
        }
        else return false;
    }
}
