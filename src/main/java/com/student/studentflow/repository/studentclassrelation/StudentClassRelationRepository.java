package com.student.studentflow.repository.studentclassrelation;


import com.student.studentflow.db.StudentClassRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentClassRelationRepository extends JpaRepository<StudentClassRelation,Long> {

}
