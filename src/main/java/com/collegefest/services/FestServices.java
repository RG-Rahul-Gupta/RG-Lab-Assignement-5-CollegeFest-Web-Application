package com.collegefest.services;

import java.util.List;

import com.collegefest.models.Students;


public interface FestServices {

	public void insertRecord(Students students);
	
	public void deleteRecord(int id);
	
	public List<Students> searchBy(String id, String name, String batch, String department,String activity,String city, String country);
	
	public Students searchByID(int id);
	
	public List<Students> listOfAll();
	
	
}
