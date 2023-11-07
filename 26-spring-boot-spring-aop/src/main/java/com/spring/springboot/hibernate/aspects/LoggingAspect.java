package com.spring.springboot.hibernate.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public void addAccount(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("@Before Advice on addAcoount()");
	}

}
