package com.ynov.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.InternalUser;
import com.ynov.productapi.repository.InternalUserRepository;

@Service
public class UserService {
	
	@Autowired
	private  InternalUserRepository userRepository;
	
	public InternalUser getUserByUsername(String name) {
		return userRepository.findByUsername(name);
	}
	public List<InternalUser> getUsers() {
		return (List<InternalUser>) userRepository.findAll();
	}

}
