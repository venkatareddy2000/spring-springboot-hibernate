package com.spring.springboot.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springboot.hibernate.dao.EmployeeDAO;
import com.spring.springboot.hibernate.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		employeeDAO.delete(theId);

	}

}
