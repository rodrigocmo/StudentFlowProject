package com.student.studentflow.repository.period;


import com.student.studentflow.db.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Long> {
}
