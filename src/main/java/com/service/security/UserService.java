package com.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}
	
	public User getUser(String username) {
		return repository.findByUsername(username).get();
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
