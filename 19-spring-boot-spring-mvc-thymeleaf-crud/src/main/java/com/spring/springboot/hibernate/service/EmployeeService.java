package com.spring.springboot.hibernate.service;

import java.util.List;

import com.spring.springboot.hibernate.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
