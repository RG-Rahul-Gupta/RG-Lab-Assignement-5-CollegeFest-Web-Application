package com.collegefest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegefest.models.Students;

@Repository
public class FestRegistrations implements FestServices{

	private SessionFactory sessionFactory;
	
	private Session session;
	
	@Autowired
	public FestRegistrations(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory ;
		try{
			session = sessionFactory.getCurrentSession();
		}
		catch(Exception e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public void insertRecord(Students students) {
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(students);
				
		tx.commit();
	}

	@Transactional
	public void updateRecord() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteRecord(int id) {
		Transaction tx = session.beginTransaction();

		// get transaction
		Students students = session.get(Students.class, id);

		// delete record
		session.delete(students);

		tx.commit();

	}

	@Transactional
	public List<Students> searchBy(String id, String name, String batch, String department, String activity, String city, String country) {
		
		Transaction tx = session.beginTransaction();
		
		String query = "";
		if(id.length()!=0 && name.length() != 0 && batch.length() != 0 && department.length() != 0 && activity.length() != 0 && city.length() != 0 && country.length() != 0)
			query =  "from Students where id like '%"+id+"%'" + 
					 " or name like '%"+name+"%'" + 
		             " or batch like '%"+batch+"%'" + 
					 " or department like '%"+department+"%'" + 
		             " or activity like '%"+activity+"%'" + 
					 " or city like '%"+city+"%'" + 
		             " or country like '%"+country+"%'";
		else if (id.length() != 0 )
			query = "from Students where id like '%" + id + "%'";
		else if (name.length() != 0 )
			query = "from Students where name like '%" + name + "%'";
		else if (batch.length() != 0)
			query = "from Students where batch like '%" + batch + "%'";
		else if (department.length() != 0)
			query = "from Students where department like '%" + department + "%'";
		else if (activity.length() != 0)
			query = "from Students where activity like '%" + activity + "%'";
		else if (city.length() != 0)
			query = "from Students where city like '%" + city + "%'";
		else if (country.length() != 0)
			query = "from Students where country like '%" + country + "%'";
		else
			System.out.println("Cannot search without input data");

		List<Students> students = session.createQuery(query).list();

		tx.commit();

		return students;
	}

	@Transactional
	public List<Students> listOfAll() {
		Transaction tx = session.beginTransaction();
		String query = "from Students" ;
		List<Students> listStudents = session.createQuery(query).list();
		tx.commit();
		return listStudents ;
	}

	@Transactional
	public Students searchByID(int id) {
        Students students = new Students();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		students = session.get(Students.class, id);

		tx.commit();

		return students;
	}


	}
	


