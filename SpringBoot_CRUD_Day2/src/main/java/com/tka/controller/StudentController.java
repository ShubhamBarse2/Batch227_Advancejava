package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entites.Student;
import com.tka.service.StudentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/studentinfo")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/savedata")
	public String insertData(@RequestBody Student s) {
		String msg = service.insertData(s);
		return msg;
	}

	@DeleteMapping("/deletebyid/{stud_id}")
	public String deleteData(@PathVariable int stud_id) {
		String msg = service.deleteData(stud_id);
		return msg;
	}

	@PutMapping("/updatebyid/{stud_id}")
	public String updateData(@RequestBody Student s, @PathVariable int stud_id) {
		String msg = service.updateData(s, stud_id);
		return msg;
	}

	@GetMapping("/getsinglerecord")
	public Student getSingleData(@RequestParam int stud_id) {
		Student s = service.getSingleData(stud_id);
		return s;
	}

	@GetMapping("/GetAllRecord")
	public List<Student> getSingleData() {
		List<Student> list = service.getAllRecord();
		return list;
	}
}
