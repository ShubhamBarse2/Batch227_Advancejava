package com.tka;

import org.springframework.stereotype.Component;

@Component("jio")
public class Jio implements Sim {

	@Override
	public String calling() {
		return "UR Calling Jio";
	}

}