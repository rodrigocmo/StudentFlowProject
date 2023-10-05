package com.student.studentflow.controller;



import com.student.studentflow.db.Shift;
import com.student.studentflow.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shift")
public class ShiftCtr {

@Autowired
ShiftService service;

@GetMapping
    public ResponseEntity<List<Shift>> findAllShift(){
        return new ResponseEntity<>(service.findAllShift(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Shift> findShiftById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findShiftById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Shift> create(@RequestBody Shift shift){
        return new ResponseEntity<>(service.create(shift),HttpStatus.CREATED);
    }



}
