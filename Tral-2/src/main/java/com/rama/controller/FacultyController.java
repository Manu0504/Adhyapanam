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

import com.rama.entity.Faculty;
import com.rama.repository.FacultyRepository;
import com.rama.service.FacultyService;

@Controller
public class FacultyController {

	private FacultyService facultyService;
	
	@Autowired
	private FacultyRepository facultyRepository;

	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	@GetMapping("/facultys")
	public String listFacultys(Model model) {
		model.addAttribute("facultys", facultyService.getAllFacultys());
		return "facultys";
	}
	
	@GetMapping("/facultys/new")
	public String createFaculty(Model model) {
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		return "create_faculty";
	}
	
	@PostMapping("/facultys")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty, @RequestParam MultipartFile file) {
		
		if (file != null && !file.isEmpty()) {
            faculty.setPhoto(file.getOriginalFilename());
            Faculty upload = facultyRepository.save(faculty);

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
		
		facultyService.saveFaculty(faculty);
		return "redirect:/facultys";
	}
	
	@GetMapping("/facultys/edit/{id}")
	public String editFaculty(@PathVariable Long id, Model model) {
		model.addAttribute("faculty", facultyService.getFacultyById(id));
		return "edit_faculty";
	}
	
	@PostMapping("/facultys/{id}")
	public String updateFaculty(@PathVariable Long id, @ModelAttribute("faculty") Faculty faculty , @RequestParam MultipartFile file, Model model){
		//get faculty by id from db
		Faculty existFaculty = facultyService.getFacultyById(id);
		existFaculty.setId(id);
		existFaculty.setFirstName(faculty.getFirstName());
		existFaculty.setMiddleName(faculty.getMiddleName());
		existFaculty.setLastName(faculty.getLastName());
		existFaculty.setDob(faculty.getDob());
		existFaculty.setGender(faculty.getGender());
		existFaculty.setEmail(faculty.getEmail());
		existFaculty.setPhone(faculty.getPhone());
		existFaculty.setAddress(faculty.getAddress());
		existFaculty.setDepartment(faculty.getDepartment());
		existFaculty.setPosition(faculty.getPosition());
		
		if (file != null && !file.isEmpty()) {
			existFaculty.setPhoto(faculty.getPhoto());

                try {
                    // Ensure the directory exists
                    File saveDirectory = new File("src/main/resources/static/images");
            
                    Path path = Paths.get(saveDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename());
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Not saved");
                }
            }
  		
		//save students
		facultyService.updateFaculty(existFaculty);
		return "redirect:/facultys";
	}
	
	@GetMapping("/facultys/{id}")
	public String deleteFaculty(@PathVariable Long id) {
		facultyService.deleteFacultyById(id);
		return "redirect:/facultys";
	}
	
}
