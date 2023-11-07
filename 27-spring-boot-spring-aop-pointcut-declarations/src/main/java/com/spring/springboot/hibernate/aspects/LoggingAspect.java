package com.spring.springboot.hibernate.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.Account;

@Order(1)
@Aspect
@Component
public class LoggingAspect {
	@After("execution(* com.spring.springboot.hibernate.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAfterAdvice(JoinPoint joinPoint) {
		String string = joinPoint.getSignature().toShortString();
		System.out.println("Method signature @After Advice : " + string);
	}

	@AfterThrowing(pointcut = "execution(* com.spring.springboot.hibernate.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		String string = joinPoint.getSignature().toShortString();
		System.out.println("Method signature @After Throwig Advice : " + string);
		System.out.println("Exception : " + exception);
	}

	@Before("com.spring.springboot.hibernate.aspects.PointcutExpression.forDaoPackageNoGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("@Before Advice on beforeAddAccountAdvice()");
		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method signature @Before Advice : " + methodSignature);

		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
		}
	}

	@AfterReturning(pointcut = "execution(* com.spring.springboot.hibernate.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		String string = joinPoint.getSignature().toShortString();
		System.out.println("Method signature @After Returning Advice : " + string);
		System.out.println("Result : " + result);
		convertAccountNamesToUpperCase(result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account tempAccount : result) {
			String upperCase = tempAccount.getName().toUpperCase();
			tempAccount.setName(upperCase);
		}
	}

	@Around("execution(* com.spring.springboot.hibernate.service.*.getFortune(..))")
	public Object afterGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// get begin timestamp
		long begin = System.currentTimeMillis();
		// now, let's execute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// result = "Major Exception";
			throw e;
		}
		// get end timestamp
		long end = System.currentTimeMillis();
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000 + " milliseconds");
		return result;
	}

}
