package com.spring.springboot.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.spring.springboot.hibernate.entity.Student;

import com.spring.springboot.hibernate.dao.StudentDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryForStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students....");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 10;

		System.out.println("Deleting student Id : " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the Id : primary key

		int studentId = 10;
		System.out.println("generated Id : " + studentId);
		Student student = studentDAO.findById(studentId);

		// change the email to venkatareddy629@gmail.com

		System.out.println("change the email...");
		student.setEmail("venkatareddy629@gmail.com");

		// update student

		studentDAO.update(student);

		// display the student

		System.out.println("updated student : " + student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		// get a list of student

		List<Student> theStudent = studentDAO.findByLastName("Prince");

		// display a list of student

		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {

		// get a list of student

		List<Student> theStudent = studentDAO.findAll();

		// display list of students

		for (Student tempStudents : theStudent) {
			System.out.println(tempStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object

		System.out.println("create student object");
		Student tempStudent4 = new Student("John", "Abraham", "Johnabraham234@gmail.com");

		// save the student object

		System.out.println("save the student object");
		studentDAO.save(tempStudent4);

		// display the id of generated object

		int theId = tempStudent4.getId();
		System.out.println("generated object : " + theId);

		// retrieve the student object by using the Id

		Student student = studentDAO.findById(theId);
		System.out.println(student);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple student objects

		System.out.println("create multiple student objects");
		Student tempStudent1 = new Student("Venkata", "Reddy", "venkatareddy629@gmail.com");
		Student tempStudent2 = new Student("Venkata", "Reddy", "venkatareddy143@gmail.com");
		Student tempStudent3 = new Student("Gopi", "Reddy", "gopireddy629@gmail.com");

		// save multiple objects

		System.out.println("save multiple student objects");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of the saved student object

		System.out.println("generated Id : " + tempStudent1.getId());
		System.out.println("generated Id : " + tempStudent2.getId());
		System.out.println("generated Id : " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("create student object");
		Student tempStudent = new Student("Challa", "Venkata Reddy", "challavenkatareddy@143gmail.com");

		// save the student object

		System.out.println("save student object");
		studentDAO.save(tempStudent);

		// display id of the saved student object

		System.out.println("Generated Id : " + tempStudent.getId());
	}

}
