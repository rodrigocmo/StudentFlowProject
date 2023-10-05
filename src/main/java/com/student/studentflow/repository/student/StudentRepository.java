package com.student.studentflow.repository.student;


import com.student.studentflow.db.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, StudentRepositoryCustom {

}
