package com.tka;

import org.springframework.stereotype.Component;

@Component("airtel")
public class Airtel implements Sim {

	@Override
	public String calling() {	
		return "UR Calling Airtel";
	}

}
