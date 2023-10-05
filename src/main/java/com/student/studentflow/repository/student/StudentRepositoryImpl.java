package com.student.studentflow.repository.student;


import com.student.studentflow.db.StatusRecord;
import com.student.studentflow.db.Student;
import com.student.studentflow.db.StudentClassRelation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.apache.kafka.common.errors.ResourceNotFoundException;

import java.util.List;


public class StudentRepositoryImpl implements StudentRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Student> findStudentNoRegistration() {
        StringBuilder hql = new StringBuilder("SELECT new Student(obj.idStudent, obj.nmStudent) ");
        hql.append(" from Student obj ");
        hql.append(" where obj.id not in(select reg.idRegistration ");
        hql.append(" from Registration reg where 1=1) ");
        hql.append(" and obj.status =:STATUS ");
        TypedQuery<Student> query = entityManager.createQuery(hql.toString(), Student.class);
        query.setParameter("STATUS", StatusRecord.ACTIVE);
        return query.getResultList();
    }

    @Override
    public StudentClassRelation findStudentMainInformation(Long id) {
        StringBuilder hql = new StringBuilder(" Select new StudentClassRelation (student.id, student.nmStudent, ");
        hql.append(" student.phone, student.email, ");
        hql.append(" reg.id, course.dcCourse , class.nmClass, b.nmBuilding ) ");
        hql.append(" from StudentClassRelation obj ");
        hql.append(" inner join obj.student student ");
        hql.append(" inner join obj.registration reg ");
        hql.append(" inner join reg.course course ");
        hql.append(" inner join obj.classroom class ");
        hql.append(" inner join class.building b ");
        hql.append(" where student.status =:STATUS ");
        hql.append(" and student.idStudent =:IDSTUDENT ");
        TypedQuery<StudentClassRelation> query = entityManager.createQuery(hql.toString(), StudentClassRelation.class);
        query.setParameter("STATUS", StatusRecord.ACTIVE);
        query.setParameter("IDSTUDENT", id);
         return query.getResultStream().findFirst().orElseThrow(() -> new ResourceNotFoundException("No records for this Student ID"));
    }

}
