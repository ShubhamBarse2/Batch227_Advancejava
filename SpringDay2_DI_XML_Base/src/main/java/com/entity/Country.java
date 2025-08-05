package com.entity;

public class Country {

	String C_id ;
	String name;
	
	public String getC_id() {
		return C_id;
	}
	public void setC_id(String c_id) {
		C_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [C_id=" + C_id + ", name=" + name + "]";
	}
	
	
	
	
}
