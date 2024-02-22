package com.cleanarch.tasksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//		(scanBasePackages = "com.cleanarch.tasksapi.core.usecases")
public class TasksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApiApplication.class, args);
	}

}
