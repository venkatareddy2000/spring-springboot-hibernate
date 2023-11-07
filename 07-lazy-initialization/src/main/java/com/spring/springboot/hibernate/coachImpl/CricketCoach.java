package com.spring.springboot.hibernate.coachImpl;

import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice bowling for 1 hour";
	}

}
