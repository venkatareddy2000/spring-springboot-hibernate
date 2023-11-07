package com.spring.springboot.hibernate.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.spring.springboot.hibernate.coachImpl",
		"com.spring.springboot.hibernate.coachInterface", "com.spring.springboot.hibernate.controller",
		"com.spring.springboot.hibernate.java.config.bean" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
