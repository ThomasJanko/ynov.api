package com.ynov.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.User;
import com.ynov.productapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;
	
	public Iterable<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

}
