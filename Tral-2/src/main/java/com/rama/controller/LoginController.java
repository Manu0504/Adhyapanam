package com.rama.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rama.entity.Faculty;
import com.rama.entity.Student;
import com.rama.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/login")
	public ModelAndView studentLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("student", new Student());
		return mav;
	}

	@PostMapping("/login")
	public String studentLogin(@ModelAttribute("student") Student student, Model model) {

		Student oauthStudent = loginService.Login(student.getUserName(), student.getPassword());

		System.out.print(oauthStudent);

		if (Objects.nonNull(oauthStudent)) {
			model.addAttribute("student", oauthStudent);
			return "student_profile";
		} else {
			return "redirect:/login";
		}
	}

	@GetMapping("/login2")
	public ModelAndView facultyLogin() {
		ModelAndView mav = new ModelAndView("login2");
		mav.addObject("faculty", new Faculty());
		return mav;
	}

	@PostMapping("/login2")
	public String facultyLogin(@ModelAttribute("faculty") Faculty faculty, Model model) {

		Faculty oauthFaculty = loginService.Login2(faculty.getUserName(), faculty.getPassword());

		System.out.print(oauthFaculty);

		if (Objects.nonNull(oauthFaculty)) {
			model.addAttribute("faculty", oauthFaculty);
			return "faculty_profile";
		} else {
			return "redirect:/login2";
		}
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";
	}

	@RequestMapping(value = { "/logout2" }, method = RequestMethod.POST)
	public String logoutDo2(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login2";
	}
}
