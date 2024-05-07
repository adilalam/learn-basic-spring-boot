package com.adil.cruddemo;

import com.adil.cruddemo.dao.StudentDAO;
import com.adil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

//			findStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudentById(studentDAO);
			
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all student  ");
		int std = studentDAO.deleteAll();
		System.out.println("deleted total count  " + std);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("delete student with id  " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		// get student by id
		int studentId = 2;
		System.out.println("Get student with id  " + studentId);

		Student student = studentDAO.findById(studentId);

		// change name
		student.setLastName("Khan");

		// update
		studentDAO.update(student);

		// display the student
		System.out.println("Update student "+ student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		System.out.println("Get student by last name ...");
		List<Student> theStudent = studentDAO.findByLastName("sonu");

		System.out.println(theStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		System.out.println("Get all student...");
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student temStudent: theStudents) {
			System.out.println(temStudent);
		}
	}

	private void findStudent(StudentDAO studentDAO) {
		System.out.println("Finding the student...");
		Student student = studentDAO.findById(3);
		System.out.println("Found the student " + student);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student...");
		Student student1 = new Student("md", "alam", "md@alam.com");
		Student student2 = new Student("Ram", "Kumar", "kumar@ram.com");
		Student student3 = new Student("Sohan", "Kumar", "kumar@sohan.com");
		Student student4 = new Student("Mohan", "Kumar", "kumar@mohan.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);

		// display id of the student
		System.out.println("Saved student. Generated id: ");
	}

}
