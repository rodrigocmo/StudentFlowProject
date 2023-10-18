package com.student.studentflow.controller;

import com.student.studentflow.db.StudentClassRelation;
import com.student.studentflow.service.StudentClassRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relation")
public class StudentClassRelationCtr {

    @Autowired
    StudentClassRelationService service;


    @PostMapping
    public ResponseEntity<StudentClassRelation> createRelation(@RequestParam Long idStudent,@RequestParam  Long idRegistration,@RequestParam  Long idClassroom){
        return new ResponseEntity<>(service.createRelation(idStudent,idRegistration,idClassroom), HttpStatus.OK);
    }

}
