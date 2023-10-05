package com.student.studentflow.repository.registration;


import com.student.studentflow.db.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
}
