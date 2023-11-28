package com.academia6_3.ESDProject.Students;

import com.academia6_3.ESDProject.OtherObjects.AuthObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<Students> getStudents() {
        return studentsService.getStudents();
    }

    @PostMapping
    public void registerNewStudents(@RequestBody Students students){
        studentsService.addNewStudents(students);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudents(@PathVariable("studentId") Long studentId){
        studentsService.deleteStudents(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudents(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String domain,
            @RequestParam(required = false) Integer rollNo) {
        studentsService.updateStudents(studentId, domain, rollNo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthObject authObject) {
        if(studentsService.authenticate(authObject)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
