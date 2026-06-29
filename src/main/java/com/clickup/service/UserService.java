package com.clickup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clickup.dto.LoginRequest;
import com.clickup.dto.RegisterRequest;
import com.clickup.entity.User;
import com.clickup.repository.UserRepository;
import com.clickup.security.JwtUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;

	public String register(RegisterRequest request) {

		Optional<User> user = repo.findByEmail(request.getEmail());

		if(user.isPresent()) {
			return "Email Already Exists";
		}

		User u = User.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(encoder.encode(request.getPassword()))
				.role("USER")
				.build();

		repo.save(u);

		return "Registration Success";
	}

	public String login(LoginRequest request) {

	    Optional<User> user = repo.findByEmail(request.getEmail());

	    if(user.isPresent()
	            && encoder.matches(
	                    request.getPassword(),
	                    user.get().getPassword())) {

	        return jwtUtil.generateToken(user.get().getEmail());
	    }

	    return "Invalid Credentials";
	}
	
	
	//to check all registered users through an API
	public List<User> getAllUsers() {
	    return repo.findAll();
	}
}