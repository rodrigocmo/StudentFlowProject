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
@Table(name = "TB_MATRICULA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private Long idRegistration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno")
    private Student student;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_PERIODO")
    private Period period;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_CURSO")
    private Course course;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "st_registro")
    private StatusRecord status;

}
