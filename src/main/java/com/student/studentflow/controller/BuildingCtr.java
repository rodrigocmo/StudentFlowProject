package com.student.studentflow.controller;


import com.student.studentflow.db.Building;
import com.student.studentflow.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/building")
public class BuildingCtr {

@Autowired
BuildingService service;

@GetMapping
    public ResponseEntity<List<Building>> findAllBuilding(){
        return new ResponseEntity<>(service.findAllBuilding(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Building> findBuildingById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBuildingById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Building> create(@RequestBody Building building){
        return new ResponseEntity<>(service.create(building),HttpStatus.CREATED);
    }



}
