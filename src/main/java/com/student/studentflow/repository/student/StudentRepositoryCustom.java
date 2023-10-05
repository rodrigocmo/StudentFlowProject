package com.student.studentflow.repository.student;


import com.student.studentflow.db.Student;
import com.student.studentflow.db.StudentClassRelation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepositoryCustom {

    List<Student> findStudentNoRegistration();

    StudentClassRelation findStudentMainInformation(Long id);
}
