package com.kadiremreozcan.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		// fist argument is i main class which anotated with @SpringBootApplication
		// second argument is the argument that that could been past to the main method
		SpringApplication.run(CourseApiApp.class, args);

	}

}
