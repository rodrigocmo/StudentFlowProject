package com.student.studentflow.repository.building;


import com.student.studentflow.db.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {
}
