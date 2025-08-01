package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Department.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Department d = new Department();
		d.setDept_name("java Developer");
		
		Employee e = new Employee();
		e.setEmp_id(10001);
		e.setEmp_name("samrat");
		e.setDept(d);
		
		ss.persist(e);

		

		tr.commit();
		ss.close();

		System.out.println("Data is inserted...");

	}

}
