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
    public ResponseEntity<StudentClassRelation> createRelation(@RequestParam (value = "idStudent") Long idStudent,
                                                               @RequestParam (value = "idRegistration") Long idRegistration,
                                                               @RequestParam (value = "idClassroom")  Long idClassroom){
        return new ResponseEntity<>(service.createRelation(idStudent,idRegistration,idClassroom), HttpStatus.OK);
    }

}
