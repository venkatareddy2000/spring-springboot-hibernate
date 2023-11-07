package com.spring.springboot.hibernate.dao;

import com.spring.springboot.hibernate.entity.Instructor;

public interface AppDAO {

	public void save(Instructor theInstructor);

	public Instructor findInstructorById(int theId);
	
	public void deleteInstrutorById(int theId);

}
