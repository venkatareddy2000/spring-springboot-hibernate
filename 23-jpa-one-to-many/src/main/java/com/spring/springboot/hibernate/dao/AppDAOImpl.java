package com.spring.springboot.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springboot.hibernate.entity.Course;
import com.spring.springboot.hibernate.entity.Instructor;
import com.spring.springboot.hibernate.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;

	@Autowired
	public AppDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);

	}

	@Override
	@Transactional
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstrutorById(int theId) {
		Instructor instructor = entityManager.find(Instructor.class, theId);
		List<Course> courses = instructor.getCourses();
		for (Course tempCourses : courses) {
			tempCourses.setInstructor(null);
		}
		entityManager.remove(instructor);
	}

	@Override
	@Transactional
	public InstructorDetail findyInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
		instructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(instructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
		query.setParameter("data", theId);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		TypedQuery<Instructor> query = entityManager
				.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :data", Instructor.class);
		query.setParameter("data", theId);
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		entityManager.merge(tempInstructor);

	}

	@Override
	@Transactional
	public void update(Course tempCourse) {
		entityManager.merge(tempCourse);

	}

	@Override
	public Course findCourseById(int theId) {
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		Course course = entityManager.find(Course.class, theId);
		entityManager.remove(course);

	}

}
