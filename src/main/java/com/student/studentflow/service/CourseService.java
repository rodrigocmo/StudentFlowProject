package com.student.studentflow.service;


import com.student.studentflow.db.Course;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;


    public List<Course> findAllCourse(){
        return repository.findAll();
    }

    public Course findCourseById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Course not found"));
    }

    public Course create(Course course){
        return repository.save(course);
    }




}
