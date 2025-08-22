package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entites.Student;

import jakarta.persistence.Query;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(s);
			tx.commit();
			msg = "Data is inserted...";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteData(int stud_id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student stud = ss.get(Student.class, stud_id);
		ss.remove(stud);

		tr.commit();
		ss.close();

		return "Data is deleted...";
	}

	public String updateData(Student s, int stud_id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student stud = ss.get(Student.class, stud_id);
		stud.setCity(s.getCity());
		stud.setName(s.getName());

		ss.merge(stud);

		tr.commit();
		ss.close();

		return "Data is updated...";
	}

	public Student getSingleData(int stud_id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Student where stud_id=:stud_id";

		Query query = ss.createQuery(hqlQuery, Student.class);
		query.setParameter("stud_id", stud_id);
		Student s = (Student) query.getSingleResult();

		tr.commit();
		ss.close();

		return s;
	}

	public List<Student> getAllRecord() {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Student";

		Query query = ss.createQuery(hqlQuery, Student.class);
		List<Student> list = query.getResultList();

		tr.commit();
		ss.close();

		return list;
	}

}
