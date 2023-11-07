package com.spring.springboot.hibernate.coachImpl;

import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class BaseBall implements Coach {
	@PostConstruct
	private void postBeanConstruction() {
		System.out.println("Post Bean Construction");
	}

	public BaseBall() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice baseball for 1 hour";
	}

	@PreDestroy
	public void preBeanDestroy() {
		System.out.println("Pre Bean Destroy");
	}

}
