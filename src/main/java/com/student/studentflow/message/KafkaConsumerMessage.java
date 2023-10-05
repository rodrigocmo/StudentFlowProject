package com.student.studentflow.message;


import com.student.studentflow.db.Student;
import com.student.studentflow.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private StudentService studentService;

    /*
    @KafkaListener(topics = "student-info-topic", groupId = "college-group")
     */
    public void listening(Student student) {

        LOG.info("CAR STORE - Received Car Post information: {}", student);
        /*Finish this tomorrow*/
        studentService.create(student);

    }


}
