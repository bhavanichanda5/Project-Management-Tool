package com.clickup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickup.dto.LoginRequest;
import com.clickup.dto.RegisterRequest;
import com.clickup.entity.User;
import com.clickup.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {

		return service.register(request);
	}

	@PostMapping("/login")
	public String login(
	        @RequestBody LoginRequest request) {

	    return service.login(request);
	}
	
	//to check all registered users through an API
	@GetMapping("/users")
	public List<User> getAllUsers() {

	    return service.getAllUsers();
	}
}