package com.tka.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/w3school")
public class MyController {

	
	@RequestMapping(value = "/html" ,method = RequestMethod.GET)
	public String firstApi() {
		return "html is stand for hypertext markup language...";
	}
	

	@GetMapping("/java")
	public String secondApi() {
		return "java is OOPs language...";
	}
	
	@DeleteMapping("/sql")
	public String thirdApi() {
		return "SQL stands for structure query language....";
	}
	
}
