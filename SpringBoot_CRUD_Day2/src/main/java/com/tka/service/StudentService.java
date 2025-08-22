package com.tka.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.StudentDao;
import com.tka.entites.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public String insertData(Student s) {
		String msg = dao.insertData(s);
		if (Objects.isNull(msg)) {
			msg = "Data is not Inserted...";
		}
		return msg;
	}

	public String deleteData(int stud_id) {
		String msg = dao.deleteData(stud_id);
		return msg;
	}

	public String updateData(Student s, int stud_id) {
		String msg = dao.updateData(s, stud_id);
		return msg;
	}

	public Student getSingleData(int stud_id) {
		Student s = dao.getSingleData(stud_id);
		return s;
	}

	public List<Student> getAllRecord() {
		List<Student> list = dao.getAllRecord();
		return list;
	}

}
