package com.spring.springboot.hibernate.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
@Aspect
public class AnalyticAspect {

	@Before("com.spring.springboot.hibernate.aspects.PointcutExpression.forDaoPackageNoGettersAndSetters()")
	public void performingAnalytics() {
		System.out.println("@Before Advice on performingAnalytics()");
	}

}
