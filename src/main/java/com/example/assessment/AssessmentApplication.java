package com.example.assessment;

import com.example.assessment.config.Config;
import com.example.assessment.models.Student;
import com.example.assessment.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class AssessmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Initialize Spring application context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// Get the StudentRepository bean
		StudentRepository repository = context.getBean(StudentRepository.class);

		// Create some sample students
		repository.createStudent("Alice", "F");
		repository.createStudent("Bob", "M");
		repository.createStudent("Alfred", "M");
		repository.createStudent("Albert", "M");

		// Find students whose names start with "Al"
		List<Student> students = repository.findStudentByName("Al");

		// Print the results
		System.out.println("Students whose names start with 'Al':");
		for (Student student : students) {
			System.out.println("Name: " + student.name + ", Gender: " + student.gender);
		}

		// Close the context
		context.close();
	}
}
