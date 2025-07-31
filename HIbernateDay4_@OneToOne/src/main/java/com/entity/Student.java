package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	private int age;
	private String name;
	
	@OneToOne
	Laptop laptop;

	public Student() {

	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Student(int stud_id, int age, String name, Laptop laptop) {
		super();
		this.stud_id = stud_id;
		this.age = age;
		this.name = name;
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", age=" + age + ", name=" + name + ", laptop=" + laptop + "]";
	}
	
	

}
