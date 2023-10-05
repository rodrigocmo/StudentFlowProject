package com.student.studentflow.controller;


import com.student.studentflow.db.Student;
import com.student.studentflow.db.StudentClassRelation;
import com.student.studentflow.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentCtr {


    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findStudentById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> create(@RequestBody Student student){
        return new ResponseEntity<>(studentService.create(student),HttpStatus.CREATED);
    }

    @PostMapping(path = "/update")
    public ResponseEntity update(@RequestBody Student student){
        return new ResponseEntity<>(studentService.update(student),HttpStatus.OK);
    }

    @PostMapping (path = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/registration")
    public ResponseEntity<List<Student>> findStudentNoRegistration(){
        return new ResponseEntity<>(studentService.findStudentNoRegistration(),HttpStatus.OK);
    }

    @GetMapping(path = "/info/{idStudent}")
    public ResponseEntity<StudentClassRelation> findStudentMainInformation(@PathVariable Long idStudent){
        return new ResponseEntity<>(studentService.findStudentMainInformation(idStudent),HttpStatus.OK);
    }


}
