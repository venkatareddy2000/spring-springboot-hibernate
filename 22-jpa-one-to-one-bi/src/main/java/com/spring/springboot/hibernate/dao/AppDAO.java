package com.spring.springboot.hibernate.dao;

import com.spring.springboot.hibernate.entity.Instructor;
import com.spring.springboot.hibernate.entity.InstructorDetail;

public interface AppDAO {

	public void save(Instructor theInstructor);

	public Instructor findInstructorById(int theId);
	
	public void deleteInstrutorById(int theId);
	
	public InstructorDetail findyInstructorDetailById(int theId);
	
	public void deleteInstructorDetailById(int theId);

}
