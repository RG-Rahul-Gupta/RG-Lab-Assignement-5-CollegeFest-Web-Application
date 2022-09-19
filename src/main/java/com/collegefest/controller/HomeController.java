package com.collegefest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	//add mapping for "/" to Reach Home Page 
	@RequestMapping("/")
	public String showHomePage() {
		return "Fest-HomePage";
	}
	
	// add mapping for "/StudentRegistration"
	
	@RequestMapping("StudentRegistration")
	public String showRegistrationPage() {
		return "Fest-RegistrationForm";	
	}
	
	// add mapping for "/RegisteredStudentRecords"
	
    @RequestMapping("RegisteredStudentRecords")
	public String showRegesit() {
		return "Fest-RegistrationRecords";	
	}
		
	
}
