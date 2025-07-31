package com.controller;

import com.entities.Student;
import com.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		
		StudentService ss = new StudentService();
		Student s = new Student();
		ss.InsertData(s);
		
	}
	
}
