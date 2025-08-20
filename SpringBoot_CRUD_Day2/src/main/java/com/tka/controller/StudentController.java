package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entites.Student;
import com.tka.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	
	@PostMapping("/savedata")
	public String insertData(@RequestBody Student s) {
		String msg = service.insertData(s);
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
