package com.student.studentflow.service;


import com.student.studentflow.db.Course;
import com.student.studentflow.db.Period;
import com.student.studentflow.db.Registration;
import com.student.studentflow.db.StatusRecord;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.registration.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;



    public List<Registration> findAllRegistration(){
        return registrationRepository.findAll();
    }

    public Registration findRegistrationById(Long id) {
        return registrationRepository.findById(id).orElseThrow(()-> new GenericExeption("Registration not found"));
    }

    public Registration create(Registration reg){
        reg.setStatus(StatusRecord.ACTIVE);
     return registrationRepository.save(reg);
    }

    public void update(Registration reg){

        registrationRepository.findById(reg.getIdRegistration()).ifPresentOrElse(item->{
            Registration update = Registration.builder().idRegistration(item.getIdRegistration())
                    .course(Course.builder().idCourse(item.getCourse().getIdCourse()).build())
                    .period(Period.builder().idPeriod(item.getPeriod().getIdPeriod()).build()).build();

            registrationRepository.save(update);
        }, ()-> {throw new NoSuchElementException();});

    }

    public void blockRegistration(Long id){
        registrationRepository.findById(id).ifPresentOrElse(item-> {
            item.setStatus(StatusRecord.CLOSED);
            registrationRepository.save(item);
        }, ()->{throw new NoSuchElementException();});

    }
}
