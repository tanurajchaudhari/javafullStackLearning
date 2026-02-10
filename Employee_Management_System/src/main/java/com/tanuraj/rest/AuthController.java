package com.tanuraj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tanuraj.entity.User;
import com.tanuraj.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		 user.setRole("USER");
		 user.setPassword(encoder.encode(user.getPassword()));
		 User save = userRepository.save(user);
		 return new ResponseEntity<User>(save,HttpStatus.CREATED);
		
	}

}
