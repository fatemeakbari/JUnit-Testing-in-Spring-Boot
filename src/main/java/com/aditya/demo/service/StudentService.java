package com.aditya.demo.service;

import com.aditya.demo.repository.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    public void addStudent(Student student);
    public void deleteStudent(Long studentId);
}
