package com.ynov.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.model.User;
import com.ynov.productapi.service.UserService;
import com.ynov.productapi.transformer.product.ProductFull;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getProducts() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{name}")
	public Iterable<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}
}
