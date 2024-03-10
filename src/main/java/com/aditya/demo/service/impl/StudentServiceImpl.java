package com.aditya.demo.service.impl;


import com.aditya.demo.repository.StudentRepository;
import com.aditya.demo.exception.BadRequestException;
import com.aditya.demo.exception.StudentNotFoundException;
import com.aditya.demo.repository.model.Student;
import com.aditya.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return new ArrayList<>();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .isExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + " taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}