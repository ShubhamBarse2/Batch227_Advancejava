package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Country;

@Configuration
public class ConfigClass {

	@Bean("con")
	public Country conObj() {
		return new Country();
	}
	

}
