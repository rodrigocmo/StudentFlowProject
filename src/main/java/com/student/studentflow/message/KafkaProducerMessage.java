package com.student.studentflow.message;



import com.student.studentflow.db.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    private final String KAFKA_TOPIC = "student-info-topic";

    public void sendMessage(Student student){
        kafkaTemplate.send(KAFKA_TOPIC, student);
    }

}
