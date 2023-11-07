package com.spring.springboot.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.hibernate.coachInterface.Coach;

@RestController
public class DemoController {

	private Coach myCoach;

	@Autowired
	public DemoController(Coach myCoach) {
		this.myCoach = myCoach;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}
