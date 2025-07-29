package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class DeleteData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = 2;
		Student s1 = ss.get(Student.class,id);
		// Get Particular record or get single record
	//	System.out.println(s1);
//		ss.delete(s1);
		ss.remove(s1);
		
		System.out.println("Data is deleted...");
		tr.commit();
		ss.close();
		
		
	}
	
}
