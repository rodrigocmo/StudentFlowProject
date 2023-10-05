package com.student.studentflow.service;


import com.student.studentflow.db.StatusRecord;
import com.student.studentflow.db.Student;
import com.student.studentflow.db.StudentClassRelation;
import com.student.studentflow.exception.GenericExeption;
import com.student.studentflow.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;



    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new GenericExeption("Student not found"));
    }

    public Student create(Student student){
        student.setStatus(StatusRecord.ACTIVE);
     return studentRepository.save(student);
    }

    public Student update(Student student){

        AtomicReference<Student> newStudent = new AtomicReference<>(new Student());

       studentRepository.findById(student.getIdStudent()).ifPresentOrElse(item->{
                Student update = Student.builder().nmStudent(student.getNmStudent())
                .birth(student.getBirth())
                .email(student.getEmail())
                .gender(student.getGender())
                .phone(student.getPhone())
                .nationality(student.getNationality()).build();
     studentRepository.save(update);
     newStudent.set(update);

        }, ()-> {throw new NoSuchElementException();});
       return newStudent.get();
    }

    public void deleteStudent(Long id){
        studentRepository.findById(id).ifPresentOrElse(item-> {
            item.setStatus(StatusRecord.CLOSED);
            studentRepository.save(item);
        }, ()->{throw new NoSuchElementException();});

    }

    public List<Student> findStudentNoRegistration(){
        return studentRepository.findStudentNoRegistration();
    }

    public StudentClassRelation findStudentMainInformation(Long idStudent){
        return studentRepository.findStudentMainInformation(idStudent);
    }


}
