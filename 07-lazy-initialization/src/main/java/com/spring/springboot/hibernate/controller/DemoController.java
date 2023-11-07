package com.spring.springboot.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.hibernate.coachInterface.Coach;

@RestController
public class DemoController {
	private Coach myCoach;

	@Autowired
	public DemoController(@Qualifier("baseBall") Coach myCoach) {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
		this.myCoach = myCoach;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
