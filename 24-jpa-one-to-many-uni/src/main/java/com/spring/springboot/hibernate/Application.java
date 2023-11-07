package com.spring.springboot.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.spring.springboot.hibernate.entity.Instructor;
import com.spring.springboot.hibernate.entity.InstructorDetail;
import com.spring.springboot.hibernate.entity.Review;
import com.spring.springboot.hibernate.entity.Course;
import com.spring.springboot.hibernate.dao.AppDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			// deleteCourseById(appDAO);

			// createCourseAndReviews(appDAO);

			// retrieveCourseAndReview(appDAO);

			deleteCourseAndReviews(appDAO);

		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 11;
		System.out.println("Deleting the Course Id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReview(AppDAO appDAO) {
		int theId = 11;
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Spring Boot");
		tempCourse.add(new Review("Good Course"));
		tempCourse.add(new Review("Average Course"));
		System.out.println("Saving the course and reviews");
		appDAO.saveCourse(tempCourse);
		System.out.println("Done");

	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting the course Id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding course Id : " + theId);
		Course course = appDAO.findCourseById(theId);
		System.out.println("Updating the Course Id : " + theId);
		course.setTitle("Spring Boot");
		appDAO.update(course);
		System.out.println("Done");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor by Id : " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Updating instructor Id :" + theId);
		instructor.setLastName("Kanala");
		appDAO.update(instructor);
		System.out.println("Done");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor by Id : " + theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("The Instructor : " + instructor);
		System.out.println("Finding courses by instructor Id :" + theId);
		System.out.println("The associated courses : " + instructor.getCourses());
		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the instructor by Id : " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("The Instructor : " + instructor);
		System.out.println("Finding courses by instructor Id :" + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		instructor.setCourses(courses);
		System.out.println("The associated courses : " + instructor.getCourses());
		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("The Instructor : " + instructor);
		System.out.println("The associated courses : " + instructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Gopi", "Reddy", "gopireddy2000@gamil.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("http://www.youtube.com", "Coding");
		tempInstructor.setInstructorDetail(tempinstructorDetail);
		Course tempCourse1 = new Course("Hibernate");
		Course tempCourse2 = new Course("Java");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor details id : " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		InstructorDetail instructorDetail = appDAO.findyInstructorDetailById(theId);
		System.out.println("Instructor Details : " + instructorDetail);
		System.out.println("Associated Instructor : " + instructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id : " + theId);
		appDAO.deleteInstrutorById(theId);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding the Instructor Id : " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor : " + instructor);
		System.out.println("Associated Instructor Details : " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		 * Instructor tempInstructor = new Instructor("Venkata", "Reddy",
		 * "venkatareddy2000@gamil.com"); InstructorDetail tempinstructorDetail = new
		 * InstructorDetail("http://venkatareddy/youtube", "Coding");
		 */
		Instructor tempInstructor = new Instructor("Gopi", "Reddy", "gopireddy2000@gamil.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("http://gopireddy/youtube", "Coding");
		tempInstructor.setInstructorDetail(tempinstructorDetail);
		System.out.println("saving instructor : " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

}
