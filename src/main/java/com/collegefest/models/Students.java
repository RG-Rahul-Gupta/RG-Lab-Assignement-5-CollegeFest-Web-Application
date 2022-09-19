package com.collegefest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Registration_id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="department")
	private String department;
	
	@Column(name="activity")
	private String activity;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;

	public Students() {

	}

	public Students(String name, String batch, String department, String activity, String city, String country) {
		super();
		this.name = name;
		this.batch = batch;
		this.department = department;
		this.activity = activity;
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", batch=" + batch + ", department=" + department
				+ ", activity=" + activity + ", city=" + city + ", country=" + country + "]";
	}

	

}
