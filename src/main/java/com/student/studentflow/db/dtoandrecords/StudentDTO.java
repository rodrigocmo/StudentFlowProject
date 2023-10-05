package com.student.studentflow.db.dtoandrecords;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private Long idStudent;
    private String nmStudent;
    private String email;
    private String phone;
    private Long idRegistration;
    private String dcCourse;
    private String nmClass;
    private String nmBuilding;


}
