package com.educandoweb.usercrud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.usercrud.entities.User;
import com.educandoweb.usercrud.repositories.UserRepository;

@Configuration // informing that it is a test class
@Profile("test") // tells you the name defined in the properties file "application-test.properties"
public class TestConfig implements CommandLineRunner { // automatically executes when the application is run

	@Autowired // annotation that automatically performs dependency injection
	private UserRepository userRepository; // dependency injection with the UserRepository c

	@Override
	public void run(String... args) throws Exception { // executed when the application is started

		User u1 = new User(null, "Maria Bronw", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));

	}

}
