package com.service;

import com.dao.StudentDao;
import com.entities.Student;

public class StudentService {

	public void InsertData(Student s) {
		StudentDao sd = new StudentDao();
		sd.insertData(s);
	}
	
}
