package com.collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collegefest.models.Students;
import com.collegefest.services.FestServices;

@Controller
@RequestMapping("students")
public class DebateRegController {
	
	@Autowired
	private FestServices festServices;
	
	//add mapping for "/UpdateRecords"
//	@RequestMapping("/UpdateRecords")
	
		
		@RequestMapping("/showRecords")
		public String listOfStudents(Model theModel) {
			List<Students> theStudents = festServices.listOfAll();
			theModel.addAttribute("Students", theStudents);
			return "Fest-RegistrationRecords";
		
	}
	
		@RequestMapping("/addRecord")
		public String insertRecord(Model theModel) {
			Students students = new Students();
			theModel.addAttribute("Students", students);
			return "Fest-RegistrationForm";
		
	}
		
		@RequestMapping("/updateRecord")
		public String showFormForUpdate(@RequestParam("RegId") int theId, Model theModel) {

			// get the Book from the service
			Students students = festServices.searchByID(theId);
					
			// set Book as a model attribute to pre-populate the form
			theModel.addAttribute("Students", students);

			// send over to our form
			return "Fest-RegistrationForm";
		}
		
		@PostMapping("/saveRecord")
		public String saveBook(@RequestParam("id") int id, 
				               @RequestParam("name") String name,
				               @RequestParam("batch") String batch,
				               @RequestParam("department") String department,
				               @RequestParam("activity") String activity,
				               @RequestParam("city") String city,
				               @RequestParam("country") String country) {

			Students students;
			if (id != 0) {
				students = festServices.searchByID(id);
				           students.setName(name);
				           students.setBatch(batch);
				           students.setDepartment(department);
				           students.setActivity(activity);
				           students.setCity(city);
				           students.setCountry(country);
			} else
				students = new Students(name, batch, department, activity, city, country);
			// save the Book
			festServices.insertRecord(students);

			// use a redirect to prevent duplicate submissions
			return "redirect:/students/showRecords";

		}
		
		@RequestMapping("/deleteRecord")
		public String delete(@RequestParam("RegId") int theId) {

			// delete the Book
			festServices.deleteRecord(theId);

			// redirect to /Books/list
			return "redirect:/students/showRecords";

		}

		@RequestMapping("/searchRecord")
		public String search(@RequestParam("id") String id, 
				             @RequestParam("name") String name, 
				             @RequestParam("batch") String batch,
				             @RequestParam("department") String department, 
				             @RequestParam("activity") String activity, 
				             @RequestParam("city") String city, 
				             @RequestParam("country") String country, 				             
				             Model theModel) {

			// check names, if both are empty then just give list of all Books

			if (id.trim().isEmpty()&& name.trim().isEmpty() && batch.trim().isEmpty() && department.trim().isEmpty() && activity.trim().isEmpty() && city.trim().isEmpty() && country.trim().isEmpty()) {
				return "redirect:/students/showRecords";
			} else {
				// else, search by first name and last name
				List<Students> theStudents = festServices.searchBy(id,name, batch, department, activity, city, country);

				// add to the spring model
				theModel.addAttribute("Students", theStudents);

				// send to list-Books
				return "Fest-RegistrationRecords";
			}

		}
		
		
		
		
		
		
		
		
		
		
		
}
