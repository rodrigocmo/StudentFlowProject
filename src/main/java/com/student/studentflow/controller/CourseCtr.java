package com.student.studentflow.controller;



import com.student.studentflow.db.Course;
import com.student.studentflow.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseCtr {

@Autowired
CourseService service;

@GetMapping
    public ResponseEntity<List<Course>> findAllCourse(){
        return new ResponseEntity<>(service.findAllCourse(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findCourseById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Course> create(@RequestBody Course course){
        return new ResponseEntity<>(service.create(course),HttpStatus.CREATED);
    }



}
