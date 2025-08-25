package com.tka.sams.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.sams.api.entity.Student;

@Repository

public class StudentDao {

	@Autowired
	private SessionFactory factory;

	public List<Student> getAllStudentsById(List<Long> studentIds) {
		Session session = null;
		List<Student> students = null;
		try {
			session = factory.openSession();
			students = session.byMultipleIds(Student.class).multiLoad(studentIds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

	public List<Student> getAllStudents() {
		Session session = null;
		List<Student> list = null;
		try {
			session = factory.openSession();

			Criteria criteria = session.createCriteria(Student.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Student createStudent(Student student) {
		Session session = null;
		Student s = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			s = student;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}

	public Student getStudentsById(long id) {
		Session session = null;
		Student student = null;
		try {
			session = factory.openSession();
			student = session.get(Student.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	public Student updateStudent(Student studentDetails) {
		Session session = null;
		Student s = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(studentDetails);
			transaction.commit();
			s = studentDetails;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return s;
	}

	public String deleteStudent(long id) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);

			if (student != null) {
				session.delete(student);
				transaction.commit();
				msg = "Deleted !!";
			} else {
				msg = "Not Exists !!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}

}
