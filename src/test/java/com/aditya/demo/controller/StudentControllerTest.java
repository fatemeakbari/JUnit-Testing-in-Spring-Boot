package com.aditya.demo.controller;

import com.aditya.demo.DemoApplication;
import com.aditya.demo.repository.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addStudent() {
        Student student = new Student("fateme", "fateme@gmail.com");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/students", student, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());

    }

    @Test
    public void shouldThrowBadRequestExceptionWhenAddStudent() {
        Student student = new Student("fateme", "fateme@gmail.com");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/students", student, String.class);
//        assertEquals(200, responseEntity.getStatusCodeValue());

        ResponseEntity<String> responseEntity2 = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/students", student, String.class);

        assertEquals(400, responseEntity2.getStatusCodeValue());


    }
}
