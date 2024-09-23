package com.rama.controller;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rama.entity.Student;
import com.rama.repository.StudentRepository;
import com.rama.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentRepository studentRepository;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		/*
		 * //For Image List<Student> list = studentRepository.findAll();
		 * model.addAttribute("list", list);
		 */
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student, @RequestParam MultipartFile file) {
		//images upload
		if (file != null && !file.isEmpty()) {
	            student.setPhoto(file.getOriginalFilename());
	            Student upload = studentRepository.save(student);

	            if (upload != null) {
	                try {
	                    // Ensure the directory exists
	                    File saveDirectory = new File("src/main/resources/static/images");
	                    if (!saveDirectory.exists()) {
	                        saveDirectory.mkdirs();
	                    }

	                    Path path = Paths.get(saveDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename());
	                    System.out.println(path);
	                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student , @RequestParam MultipartFile file, Model model){
		//get students by id from db
		Student existStudent = studentService.getStudentById(id);
		existStudent.setId(id);
		existStudent.setFirstName(student.getFirstName());
		existStudent.setMiddleName(student.getMiddleName());
		existStudent.setLastName(student.getLastName());
		existStudent.setDob(student.getDob());
		existStudent.setGender(student.getGender());
		existStudent.setEmail(student.getEmail());
		existStudent.setPhone(student.getPhone());
		existStudent.setAddress(student.getAddress());
		existStudent.setCourse(student.getCourse());
		existStudent.setYear(student.getYear());
		
		// Handle photo update
        if (file != null && !file.isEmpty()) {
            existStudent.setPhoto(file.getOriginalFilename());
            try {
                // Ensure the directory exists
                File saveDirectory = new File("src/main/resources/static/images");
          
                Path path = Paths.get(saveDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		//save students
		studentService.updateStudent(existStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		 studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	/*
	 * @GetMapping("/students/search") public ResponseEntity<List<Student>>
	 * searchStudent(@RequestParam String Name){
	 * 
	 * List<Student> students = studentService.searchStudents(Name); return new
	 * ResponseEntity<>(students, HttpStatus.OK);
	 * 
	 * }
	 */
	
}
