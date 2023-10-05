package com.student.studentflow.controller;


import com.student.studentflow.db.Registration;
import com.student.studentflow.db.Student;
import com.student.studentflow.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationCtr {


    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> findAllRegistration() {
        return new ResponseEntity<>(registrationService.findAllRegistration(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Registration> findRegistrationById(@PathVariable Long id) {
        return new ResponseEntity<>(registrationService.findRegistrationById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Registration> create(@RequestBody Registration registration){
        return new ResponseEntity<>(registrationService.create(registration),HttpStatus.CREATED);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Registration> update(@RequestBody Student student){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping (path = "/{id}")
    public ResponseEntity blockRegistration(@PathVariable Long id){
        registrationService.blockRegistration(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
