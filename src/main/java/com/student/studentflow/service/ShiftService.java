package com.student.studentflow.service;

import com.student.studentflow.db.Shift;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.shift.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {

    @Autowired
    ShiftRepository repository;


    public List<Shift> findAllShift(){
        return repository.findAll();
    }

    public Shift findShiftById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Shift not found"));
    }

    public Shift create(Shift shift){
        return repository.save(shift);
    }




}
