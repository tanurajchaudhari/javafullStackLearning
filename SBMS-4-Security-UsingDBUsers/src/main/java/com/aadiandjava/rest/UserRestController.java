package com.aadiandjava.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.entity.User;
import com.aadiandjava.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class UserRestController {
	@Autowired
	UserRepository repository;
	@Autowired
     PasswordEncoder  passwordEncoder;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if(user.getUsername().equals("Aadiandjava") ||user.getUsername().equals("Aadiandpython")) {
			user.setRole("ADMIN");
		}else {
			user.setRole("USER"); 
		}
		
		
		User savedUSer = repository.save(user);
		return new ResponseEntity<User>(savedUSer,HttpStatus.OK);
	}

}
