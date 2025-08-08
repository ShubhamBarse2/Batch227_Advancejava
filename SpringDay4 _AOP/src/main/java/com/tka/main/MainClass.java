package com.tka.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tka.config.MyConfigClass;
import com.tka.entity.Recharge;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigClass.class);
		Recharge r =  context.getBean(Recharge.class);
		r.myRecharge();

	}

}
