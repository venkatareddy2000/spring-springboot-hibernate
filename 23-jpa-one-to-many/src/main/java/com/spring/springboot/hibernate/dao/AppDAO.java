package com.spring.springboot.hibernate.dao;

import java.util.List;

import com.spring.springboot.hibernate.entity.Course;
import com.spring.springboot.hibernate.entity.Instructor;
import com.spring.springboot.hibernate.entity.InstructorDetail;

public interface AppDAO {

	public void save(Instructor theInstructor);

	public Instructor findInstructorById(int theId);

	public void deleteInstrutorById(int theId);

	public InstructorDetail findyInstructorDetailById(int theId);

	public void deleteInstructorDetailById(int theId);

	public List<Course> findCoursesByInstructorId(int theId);

	public Instructor findInstructorByIdJoinFetch(int theId);

	public void update(Instructor tempInstructor);

	public void update(Course tempCourse);

	public Course findCourseById(int theId);
	
	public void deleteCourseById(int theId);

}
