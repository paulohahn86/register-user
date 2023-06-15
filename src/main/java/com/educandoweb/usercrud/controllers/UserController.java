package com.educandoweb.usercrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educandoweb.usercrud.entities.User;
import com.educandoweb.usercrud.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired // automatically injected
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);

	}
	
	@GetMapping(value = "/{id}") // annotation that returns by ID
	public ResponseEntity<User> fingById(@PathVariable Long id){ // Annotation for spring to recognize the argument coming from the rest controller
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj); // ok returns true successfully completed and body takes as argument my User
	}

}
