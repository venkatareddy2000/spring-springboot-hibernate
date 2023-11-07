package com.spring.springboot.hibernate.restcontroller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.hibernate.entity.Student;
import com.spring.springboot.hibernate.exception.StudentErrorResponse;
import com.spring.springboot.hibernate.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	public List<Student> theStudent;

	@PostConstruct
	public void loadData() {

		theStudent = new ArrayList<>();

		theStudent.add(new Student("Venkata", "Reddy"));
		theStudent.add(new Student("Gopi", "Reddy"));
		theStudent.add(new Student("Mahesh", "Reddy"));

	}

	@GetMapping("/student")
	public List<Student> getStudent() {

		return theStudent;

	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {

		if (studentId > theStudent.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found : " + studentId);
		}
		return theStudent.get(studentId);
	}

}
