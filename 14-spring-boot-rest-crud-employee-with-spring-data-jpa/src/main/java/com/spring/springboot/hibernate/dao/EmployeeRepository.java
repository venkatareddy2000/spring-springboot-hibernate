package com.spring.springboot.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.hibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
