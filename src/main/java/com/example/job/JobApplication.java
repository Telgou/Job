package com.example.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
	@Autowired
	private JobRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) ->{

			repository.save( new Job(1, "Job1", true) );
			repository.save( new Job(2, "Job2", false) );
			repository.save( new Job(3, "Job3", true) );

			repository.findAll().forEach(System.out::println );

		};
	}

}