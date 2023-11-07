package com.spring.springboot.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.springboot.hibernate.dao.AccountDAO;
import com.spring.springboot.hibernate.dao.MembershipDAO;
import com.spring.springboot.hibernate.service.TrafficFortuneService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO,
			TrafficFortuneService theTrafficFortuneService) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceThrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceThrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Calling the getFortune()");
		boolean tripWire = true;
		String fortune = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("The data : " + fortune);
		System.out.println("Finished");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Calling the getFortune()");
		boolean tripWire = true;
		String fortune = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("The data : " + fortune);
		System.out.println("Finished");

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Calling the getFortune()");
		String fortune = theTrafficFortuneService.getFortune();
		System.out.println("The data : " + fortune);
		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> findAccounts = null;
		try {
			boolean tripWire = false;
			findAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Caught exception : " + e);
		}
		System.out.println(findAccounts);

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> findAccounts = null;
		try {
			boolean tripWire = true;
			findAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Caught exception : " + e);
		}
		System.out.println(findAccounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> findAccounts = theAccountDAO.findAccounts();
		System.out.println(findAccounts);
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMemebershipDAO) {
		Account account = new Account("Venkata Reddy", "venkatareddy629@gmail.com");
		theAccountDAO.addAccount(account, true);
		theAccountDAO.setName();
		theAccountDAO.getName();
		theAccountDAO.setServiceCode();
		theAccountDAO.getServiceCode();
		theMemebershipDAO.addAccount();
	}

}
