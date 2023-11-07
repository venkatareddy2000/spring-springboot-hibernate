package com.spring.springboot.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springboot.hibernate.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
		List<Employee> employee = theQuery.getResultList();
		return employee;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {

		Employee dbEmployee = entityManager.merge(theEmployee);

		return dbEmployee;
	}

	@Override
	public void delete(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		entityManager.remove(theEmployee);

	}

}
