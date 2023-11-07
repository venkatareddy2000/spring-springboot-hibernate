package com.spring.springboot.hibernate.coachImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
@Primary
public class BaseBall implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice baseball for 1 hour";
	}

}
