package com.rama.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rama.entity.Student;
import com.rama.repository.StudentRepository;
import com.rama.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository; 
    }

    @Override
    public List<Student> getAllStudents() {        
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

	/*
	 * @Override public List<Student> searchStudents(String name) { return
	 * studentRepository.searchStudent(name); }
	 */

}
