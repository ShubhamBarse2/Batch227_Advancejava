package com.tka.sams.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.StudentDao;
import com.tka.sams.api.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public List<Student> getAllStudentsById(List<Long> studentIds) {
		return dao.getAllStudentsById(studentIds);
	}

	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	public Student createStudent(Student student) {
		return dao.createStudent(student);
	}

	public Student getStudentById(long id) {
		return dao.getStudentsById(id);
	}

	public Student updateStudent(Student studentDetails) {
		return dao.updateStudent(studentDetails);
	}

	public String deleteStudent(long id) {
		return dao.deleteStudent(id);
	}
}
