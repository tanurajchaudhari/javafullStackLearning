package com.veracity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veracity.entity.User;
import com.veracity.repo.UserRepository;

@RestController
public class UserRestController {

	@GetMapping("/welcome")
	public String welcomeMSg()
	{
		return "Welcome Everyone";
	}
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/save")
	public ResponseEntity<User> createUsers(@RequestBody User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		
		 user.setRole("USER");
		User savedUser = repository.save(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
}
