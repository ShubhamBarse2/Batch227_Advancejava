package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

	@Id
	int l_id;
	String l_name;

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Laptop(int l_id, String l_name) {
		super();
		this.l_id = l_id;
		this.l_name = l_name;
	}

	@Override
	public String toString() {
		return "Laptop [l_id=" + l_id + ", l_name=" + l_name + "]";
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

}
