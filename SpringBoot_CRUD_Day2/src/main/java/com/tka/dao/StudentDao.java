package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entites.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		
		tr.commit();
		ss.close();
		
		return "Data is inserted...";
	}

}
