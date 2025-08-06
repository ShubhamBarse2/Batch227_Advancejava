package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ConfigClass;
import com.entity.Country;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Country c = context.getBean("con",Country.class);
		System.out.println(c);

	}

}
