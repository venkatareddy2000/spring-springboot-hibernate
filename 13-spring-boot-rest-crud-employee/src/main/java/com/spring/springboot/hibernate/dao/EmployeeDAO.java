package com.spring.springboot.hibernate.dao;

import java.util.List;

import com.spring.springboot.hibernate.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void delete(int theId);

}
