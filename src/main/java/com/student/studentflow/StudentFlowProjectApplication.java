package com.student.studentflow;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.TimeZone;

@EnableEurekaServer
@SpringBootApplication
@EnableKafka
/*
@EnableJpaRepositories("com.college.repository.*")
@ComponentScan({"com.college.*"})
@EntityScan("com.college.db.*")
*/

public class StudentFlowProjectApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Fortaleza"));
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentFlowProjectApplication.class, args);
    }

}
