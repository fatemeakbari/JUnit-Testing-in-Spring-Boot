package com.aditya.demo.repository;

import com.aditya.demo.repository.model.Student;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void itShouldCheckIfStudentEmailExists() {
        //Given
        String email = "fateme@gmail.com";
        Student student = new Student();
        student.setName("fateme");
        student.setEmail(email);

        studentRepository.save(student);

        //When
        boolean expected = studentRepository.isExistsEmail(email);

        //Then
        assertTrue(expected);
    }

    @Test
    public void itShouldCheckIfStudentEmailDoesNotExists() {
        //Given
        String email = "megri@gmail.com";

        //When
        boolean expected = studentRepository.isExistsEmail(email);

        //Then
        assertFalse(expected);
    }

    @AfterEach
    public void tearDown(){
        studentRepository.deleteAll();
    }

}
