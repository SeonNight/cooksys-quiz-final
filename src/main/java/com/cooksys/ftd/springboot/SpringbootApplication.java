package com.cooksys.ftd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Controller - Has the GET, POST, DELET, etc methods
 * Service - Higher level abstractions
 * Repository - Actually mess with data
 * Entities - Data Transfer Objects
 * Database - Where data is stored
 * 
 * Controllers - contains application logic and passing user input data to service
 * Services - The middleware between controller and repository. Gather data from controller,
 * 	performs validation and business logic, and calling repositories for data manipulation.
 * Repositories - layer for interaction with models and performing DB operations
 */

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
