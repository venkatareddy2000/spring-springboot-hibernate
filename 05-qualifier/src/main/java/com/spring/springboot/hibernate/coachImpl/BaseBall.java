package com.spring.springboot.hibernate.coachImpl;

import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
public class BaseBall implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice baseball for 1 hour";
	}

}
