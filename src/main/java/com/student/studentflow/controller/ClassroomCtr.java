package com.student.studentflow.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.studentflow.db.Classroom;
import com.student.studentflow.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/classroom")
@RestController
public class ClassroomCtr {

        @Autowired
        ClassroomService service;

    @GetMapping
    public ResponseEntity<List<Classroom>> findAllClass() {
        return new ResponseEntity<>(service.findAllClass(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Classroom> findCLassById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findClassById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Classroom> create(@RequestBody Classroom classroom){
        return new ResponseEntity<>(service.create(classroom),HttpStatus.CREATED);
    }

    @GetMapping(path = "json")
    //generate json
    public void test() throws JsonProcessingException {
        // Criar um objeto MyClass fictício
        Classroom myObject = new Classroom();
        myObject.setNmClass("MinhaClasse");
        // Defina os outros atributos...

        // Inicialize o ObjectMapper do Jackson
        ObjectMapper objectMapper = new ObjectMapper();

        // Converter o objeto MyClass em JSON
        String jsonString = objectMapper.writeValueAsString(myObject);

        // Imprimir o JSON gerado
        System.out.println(jsonString);
    }

}
