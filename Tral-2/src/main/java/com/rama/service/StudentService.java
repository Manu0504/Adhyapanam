package com.rama.service;

import java.util.List;

import com.rama.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();
    
    Student saveStudent(Student student);
    
    Student getStudentById(Long id);

    Student updateStudent(Student student);
    
    void deleteStudentById(Long id);

	/* List<Student> searchStudents(String name); */
}
