package com.student.studentflow.message;



import com.student.studentflow.db.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

    private final String INCREASE_TOPIC = "student-increase-topic";

    private final String DECREASE_TOPIC = "student-decrease-topic";
    public void increaseStudentNumberInClass(Long idClassroom ){
        kafkaTemplate.send(INCREASE_TOPIC, idClassroom);
    }

    public void decreaseStudentNumberInClass(Long idClassroom ){
        kafkaTemplate.send(DECREASE_TOPIC, idClassroom);
    }

}
