package com.ynov.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.model.InternalUser;
import com.ynov.productapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<InternalUser> getProducts() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{username}")
	public InternalUser getUserByUsername(@PathVariable("username") String name) {
		return userService.getUserByUsername(name);
	}
}
