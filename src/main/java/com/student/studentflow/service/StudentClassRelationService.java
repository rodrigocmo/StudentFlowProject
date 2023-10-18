package com.student.studentflow.service;


import com.student.studentflow.db.Classroom;
import com.student.studentflow.db.Registration;
import com.student.studentflow.db.Student;
import com.student.studentflow.db.StudentClassRelation;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.external.RestTemplateRequests;
import com.student.studentflow.repository.studentclassrelation.StudentClassRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentClassRelationService {

    @Autowired
    StudentClassRelationRepository repository;

    @Autowired
    RestTemplateRequests rest;

    public StudentClassRelation createRelation(Long idStudent, Long idRegistration, Long idClassroom){
        if(rest.findVacancies(idClassroom).getBody() <= Long.valueOf(0)) {
            throw new GenericExeption("No vacancies left in this classroom");
        }
       return repository.save(StudentClassRelation.builder()
               .student(Student.builder().idStudent(idStudent).build())
               .registration(Registration.builder().idRegistration(idRegistration).build())
               .classroom(Classroom.builder().id(idClassroom).build()).build());

    }



}
