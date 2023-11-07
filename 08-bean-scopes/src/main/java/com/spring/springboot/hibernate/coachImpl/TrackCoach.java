package com.spring.springboot.hibernate.coachImpl;

import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
public class TrackCoach implements Coach {

	public TrackCoach() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice running for 1 hour";
	}

}
