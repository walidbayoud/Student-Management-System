package com.project.sbrdemo.service;

import com.project.sbrdemo.model.Student;

import java.util.List;

public interface IStudentService {
    //our Methods
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);

}
