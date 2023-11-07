package com.spring.springboot.hibernate.coachImpl;

import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
public class SwimCoach implements Coach {

	public SwimCoach() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice swimming for 1 hour";
	}

}
