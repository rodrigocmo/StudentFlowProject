package com.student.studentflow.repository.classroom;


import com.student.studentflow.db.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
