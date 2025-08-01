package com.main;

import java.util.ArrayList;

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

		Employee e1 = new Employee();
		e1.setEmp_id(1001);
		e1.setEmp_name("sanket");
		e1.setDept(d);

		Employee e2 = new Employee();
		e2.setEmp_id(1002);
		e2.setEmp_name("rahul");
		e2.setDept(d);

		Employee e3 = new Employee();
		e3.setEmp_id(1003);
		e3.setEmp_name("sahil");
		e3.setDept(d);

		ArrayList list = new ArrayList();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		ss.persist(d);
		ss.persist(e1);
		ss.persist(e2);
		ss.persist(e3);
		d.setEmp(list);

		tr.commit();
		ss.close();

		System.out.println("Data is inserted...");

	}

}
