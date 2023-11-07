package com.spring.springboot.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.hibernate.coachInterface.Coach;

@RestController
public class DemoController {
	private Coach myCoach;
	private Coach myCoach1;

	@Autowired
	public DemoController(@Qualifier("baseBall") Coach myCoach, @Qualifier("baseBall") Coach myCoach1) {
		System.out.println("Initializing constructor : " + getClass().getSimpleName());
		this.myCoach = myCoach;
		this.myCoach1 = myCoach1;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

	@GetMapping("/check")
	public String check() {
		return "comparing beans : myCoach == myCoach1 " + (myCoach == myCoach1);
	}

}
