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

	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public User update(User user, Long id) {
		User userFind = findById(id);
		userFind.setId(id);
		userFind.setName(user.getName());
		userFind.setEmail(user.getEmail());
		userFind.setPhone(user.getPhone());
		userFind.setPassword(user.getPassword());
		return userRepository.save(userFind);

	}

}
