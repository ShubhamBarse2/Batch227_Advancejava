package com.tka.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAspects {

	@Before("execution( public void myRecharge())")
	public void beforeRecharge() {
		System.out.println("U R Recharge Expiring Soon plz Recharge...! ");
	}
//
//	@After("execution (* com.tka.entity.Recharge.*(..))")
//	public void afterRecharge() {
//		System.out.println("Recharge Successfully... Enjoy UR Data Pack...!  ");
//	}

	@Around("execution (* com.tka.entity.Recharge.*(..))")
	public void aroundMsg(ProceedingJoinPoint p) {
		System.out.println("U R Recharge Expiring Soon plz Recharge...!");

		try {
			p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Recharge Successfully... Enjoy UR Data Pack...!  ");
	}

}
