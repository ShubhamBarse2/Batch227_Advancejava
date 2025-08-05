package com.entity;

public class Employee {

	private int emp_id;
	private String name;
	private String salary;
	private Country con;

	public Country getCon() {
		return con;
	}

	public void setCon(Country con) {
		this.con = con;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", con=" + con + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
