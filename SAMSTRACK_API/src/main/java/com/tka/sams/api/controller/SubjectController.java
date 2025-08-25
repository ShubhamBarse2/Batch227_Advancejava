package com.tka.sams.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tka.sams.api.entity.Subject;
import com.tka.sams.api.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin("http://localhost:4200")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/get-all-subjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubjects();
	}

	@PostMapping("/add-subject")
	@CrossOrigin(methods = RequestMethod.POST)
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}

	@GetMapping("/get-subject-by-id/{id}")
	public Subject getSubjectById(@PathVariable long id) {
		return subjectService.getSubjectById(id);
	}
	
	@PutMapping("/update-subject")
	@CrossOrigin(methods = RequestMethod.PUT)
	public Subject updateSubject(@RequestBody Subject subjectDetails) {

		return subjectService.updateSubject(subjectDetails);
	}

	@DeleteMapping("/delete-subject/{id}")
	public String deleteSubject(@PathVariable long id) {
		return subjectService.deleteSubject(id);
	}
}
