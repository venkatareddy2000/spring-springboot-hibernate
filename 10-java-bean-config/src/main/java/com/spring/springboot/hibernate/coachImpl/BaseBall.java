package com.spring.springboot.hibernate.coachImpl;

import com.spring.springboot.hibernate.coachInterface.Coach;

public class BaseBall implements Coach {

	public BaseBall() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice baseball for 1 hour";
	}

}
