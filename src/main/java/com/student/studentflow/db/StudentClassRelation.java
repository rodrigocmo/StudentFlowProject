package com.student.studentflow.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_enturmacao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentClassRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matricula")
    private Registration registration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma")
    private Classroom classroom;

    public StudentClassRelation(Long idStudent, String nmStudent, String phone, String email, Long idRegistration,
                                String dcCourse, String nmClass, String nmBuilding) {
        this.student = Student.builder().idStudent(idStudent).nmStudent(nmStudent).phone(phone).email(email).build();
        this.registration = Registration.builder().idRegistration(idRegistration).build();
        this.classroom = Classroom.builder().nmClass(nmClass).building(Building.builder().nmBuilding(nmBuilding).build()).build();
    }
}
