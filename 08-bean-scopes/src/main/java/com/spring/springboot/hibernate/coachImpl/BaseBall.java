package com.spring.springboot.hibernate.coachImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.springboot.hibernate.coachInterface.Coach;

@Component
@Scope("prototype")
public class BaseBall implements Coach {

	public BaseBall() {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "Practice baseball for 1 hour";
	}

}
