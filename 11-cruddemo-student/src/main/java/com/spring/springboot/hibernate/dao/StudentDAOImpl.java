package com.spring.springboot.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springboot.hibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);

	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TypedQuery<Student> theQuery = entityManager.createQuery("From Student",
		// Student.class);

		// TypedQuery<Student> theQuery = entityManager.createQuery("From Student order
		// by lastName", Student.class);

		// TypedQuery<Student> theQuery = entityManager.createQuery("From Student order
		// by lastName asc", Student.class);

		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName desc", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {

		// create query

		TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName = : theData ",
				Student.class);

		// set parameters

		theQuery.setParameter("theData", theLastName);

		// return the result
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer studentId) {

		// retrieve the student

		Student student = entityManager.find(Student.class, studentId);

		// delete the student

		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("Delete FROM Student").executeUpdate();
		return numRowsDeleted;
	}

}
