package com.aditya.demo.service;

import com.aditya.demo.repository.StudentRepository;
import com.aditya.demo.exception.BadRequestException;
import com.aditya.demo.repository.model.Student;
import com.aditya.demo.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
//    AutoCloseable closeable;
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        //initializes fields annotated with Mockito annotations
//        closeable = MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
//        closeable.close();
    }

    @Test
    public void getAllStudent(){
        //when
        studentService.getAllStudents();
        //Then
        verify(studentRepository).findAll();
    }


    @Test
    public void canAddStudent(){

        //given
        Student student = new Student("fateme", "fateme@gmail.com");

        //when
        studentService.addStudent(student);

        //then
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(captor.capture());

        Student capturedStudent = captor.getValue();

        assertEquals(student, capturedStudent);

    }

    @Test
    public void willThrowWhenEmailIsTaken(){
        //given
        String email = "fateme@gmail.com";
        Student student = new Student("fateme", email);

        when(studentRepository.isExistsEmail(email)).thenReturn(true);

        //then
        assertThrows(BadRequestException.class, () -> studentService.addStudent(student));
    }

    @Test
    @Disabled
    public void deleteStudent(){

    }
}
