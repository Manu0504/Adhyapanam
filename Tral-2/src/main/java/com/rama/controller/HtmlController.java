package com.rama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

	@RequestMapping("/index.html")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/about.html")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/contact.html")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/course.html")
	public String course() {
		return "course";
	}
	
	@RequestMapping("/facultys.html")
	public String faculty() {
		return "facultys";
	}
	
	@RequestMapping("/students.html")
	public String student() {
		return "students";
	}
	
	@RequestMapping("/gallery.html")
	public String gallery() {
		return "gallery";
	}

	@RequestMapping("/student_profile")
	public String profile(){
		return "student_profile";
	}
	
	@RequestMapping("/faculty_profile")
	public String profile2(){
		return "faculty_profile";
	}
	
}
