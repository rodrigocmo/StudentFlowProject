package com.student.studentflow.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_aluno_documento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idStudentDoc;

    @Column(name = "orgao_expedidor")
    private String issuing_org;

    @Column(name = "data_emissao")
    private LocalDate issuance_date;

    @Column(name = "identidade")
    private String identity;

    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_ALUNO")
    private Student student;

}
