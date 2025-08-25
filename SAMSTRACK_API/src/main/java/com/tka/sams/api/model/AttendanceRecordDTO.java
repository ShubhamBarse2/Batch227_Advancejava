package com.tka.sams.api.model;

import java.util.List;
import java.util.stream.Collectors;

import com.tka.sams.api.entity.AttendanceRecord;

public class AttendanceRecordDTO {
    private String id;
    private String username;
    private String firstNme; // Assuming you want the faculty's name as well
    private Long subjectId;
    private String subjectName; // Assuming you want the subject's name as well
    private String date;
    private String time;
    private int numberOfStudents;
    private List<StudentDTO> students;

    // Constructor
    public AttendanceRecordDTO(AttendanceRecord record) {
        this.id = record.getId();
        this.username = record.getUser().getUsername();
        this.firstNme = record.getUser().getFirstName(); 
        this.subjectId = record.getSubject().getId();
        this.subjectName = record.getSubject().getName();
        this.numberOfStudents = record.getNumberOfStudents();
        this.students = record.getStudents().stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstNme() {
		return firstNme;
	}

	public void setFirstNme(String firstNme) {
		this.firstNme = firstNme;
	}

	public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

   

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
