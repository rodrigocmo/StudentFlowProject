package com.student.studentflow.controller;



import com.student.studentflow.db.Period;
import com.student.studentflow.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/period")
public class PeriodCtr {

@Autowired
PeriodService service;

@GetMapping
    public ResponseEntity<List<Period>> findAllPeriod(){
        return new ResponseEntity<>(service.findAllPeriod(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Period> findPeriodById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findPeriodById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Period> create(@RequestBody Period period){
        return new ResponseEntity<>(service.create(period),HttpStatus.CREATED);
    }



}
