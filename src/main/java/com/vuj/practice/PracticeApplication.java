package com.vuj.practice;

import com.vuj.practice.model.User;
import com.vuj.practice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("Janos10", "janos@gmail.com", "af34awresfdy"));
			userRepository.save(new User("_Bela_", "bela@gmail.com", "be14ak1r41y"));
		};
	}

}
