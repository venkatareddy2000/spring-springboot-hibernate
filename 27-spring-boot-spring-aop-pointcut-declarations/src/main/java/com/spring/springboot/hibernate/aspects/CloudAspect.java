package com.spring.springboot.hibernate.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class CloudAspect {

	@Before("com.spring.springboot.hibernate.aspects.PointcutExpression.forDaoPackageNoGettersAndSetters()")
	public void logToCloud() {
		System.out.println("@Before Advice on logToCloud()");
	}

}
