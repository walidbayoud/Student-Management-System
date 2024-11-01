package com.project.sbrdemo.service;

import com.project.sbrdemo.exception.StudentAlreadyExistsException;
import com.project.sbrdemo.exception.StudentNotFoundException;
import com.project.sbrdemo.model.Student;
import com.project.sbrdemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    //Implementing each method
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student addStudent(Student student) {
        if (StudentAlreadyExistsException(student.getEmail()))
        {
            throw new StudentAlreadyExistsException(student.getEmail() + " already exists!");
        }
        return studentRepository.save(student);
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setDepartment(student.getDepartment());
            st.setEmail(student.getEmail());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Student Not Found!"));
    }


    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with given Id Not Found!- id="+ id));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id))
            throw new StudentNotFoundException("Student not Found!");
        studentRepository.deleteById(id);

    }

    private boolean StudentAlreadyExistsException(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}
