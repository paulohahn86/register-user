package com.educandoweb.usercrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.usercrud.entities.User;
import com.educandoweb.usercrud.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service // registers the class as a spring service so it can be automatically injected into the UserRepository class
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> findAll(){		
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public User findById(Long id) {		
		Optional<User> obj =  userRepository.findById(id);
		return obj.get();
	}

}
