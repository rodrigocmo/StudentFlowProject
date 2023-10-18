package com.student.studentflow.service;


import com.student.studentflow.db.StudentClassRelation;
import com.student.studentflow.repository.studentclassrelation.StudentClassRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentClassRelationService {

    @Autowired
    StudentClassRelationRepository respository;

    public ResponseEntity<StudentClassRelation> createRelation(Long idStudent, Long idRegistration, Long idClassroom){

    }



}
