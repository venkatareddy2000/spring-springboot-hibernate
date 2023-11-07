package com.spring.springboot.hibernate.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpression {
	@Pointcut("execution(* com.spring.springboot.hibernate.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.spring.springboot.hibernate.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.spring.springboot.hibernate.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage()&&!(getter()||setter())")
	public void forDaoPackageNoGettersAndSetters() {
		System.out.println("@Before Advice on addAcoount()");
	}
}
