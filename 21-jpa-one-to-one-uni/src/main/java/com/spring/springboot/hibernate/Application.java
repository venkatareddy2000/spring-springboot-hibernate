package com.spring.springboot.hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.spring.springboot.hibernate.entity.Instructor;
import com.spring.springboot.hibernate.entity.InstructorDetail;
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

			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
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
