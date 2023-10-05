package com.student.studentflow.service;


import com.student.studentflow.db.Period;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.period.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {

    @Autowired
    PeriodRepository repository;


    public List<Period> findAllPeriod(){
        return repository.findAll();
    }

    public Period findPeriodById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Period not found"));
    }

    public Period create(Period period){
        return repository.save(period);
    }




}
