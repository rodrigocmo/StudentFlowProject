package com.student.studentflow.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_ALUNO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idStudent;

    @Column(name = "NOME")
    private String nmStudent;

    @Column(name = "data_nascimento")
    private LocalDate birth;

    @Column(name = "email")
    private String email;

    @Column(name = "nacionalidade")
    private String nationality;

    @Column(name = "sexo")
    private char gender;

    @Column(name = "telefone")
    private String phone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "st_registro")
    private StatusRecord status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval=true)
    private List<Registration> registration;

    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, orphanRemoval=true)
    private List<StudentDoc> studentDoc;

    public Student(Long idStudent, String nmStudent) {
        this.idStudent = idStudent;
        this.nmStudent = nmStudent;
    }

    public Student(Long idStudent, String nmStudent, String email, String phone, List<Registration> registration, List<StudentDoc> studentDoc) {
        this.idStudent = idStudent;
        this.nmStudent = nmStudent;
        this.phone = phone;
        this.email = email;
        this.registration = registration;
        this.studentDoc = studentDoc;
    }
}
