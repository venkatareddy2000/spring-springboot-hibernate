package com.spring.springboot.hibernate.java.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.springboot.hibernate.coachImpl.BaseBall;

@Configuration
public class SportsBeanConfiguration {

	public SportsBeanConfiguration() {
		System.out.println("Initializing Constructor : " + getClass().getSimpleName());
	}

	@Bean
	public BaseBall baseBall() {
		return new BaseBall();
	}

}
