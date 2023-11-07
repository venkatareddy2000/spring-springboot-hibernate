package com.spring.springboot.hibernate.dao;

import java.util.List;

import com.spring.springboot.hibernate.entity.Student;

public interface StudentDAO {

	public void save(Student theStudent);

	public Student findById(Integer id);

	public List<Student> findAll();

	public List<Student> findByLastName(String theLastName);

	public void update(Student theStudent);
	
	public void delete(Integer studentId);
	
	public int deleteAll();

}
