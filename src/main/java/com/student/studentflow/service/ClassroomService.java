package com.student.studentflow.service;


import com.student.studentflow.db.Classroom;
import com.student.studentflow.db.StatusRecord;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.classroom.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository repository;



    public List<Classroom> findAllClass(){
        return repository.findAll();
    }

    public Classroom findClassById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Classroom not found"));
    }

    public Classroom create(Classroom classroom){
        classroom.setStatus(StatusRecord.ACTIVE);
     return repository.save(classroom);
    }

}
