package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.helper.UserFoundException;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/welcome")
	public  void welcome() {
		System.err.println("welcome");
	}

	@Autowired
	public  BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//creating user
	@PostMapping("/")
	public  User createUser(@RequestBody User user) throws Exception {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setProfile("default.png");
		Set<UserRole>roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(55);
		role.setRoleName("Normal");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.createUser(user,roles);
		
	}
	//get user by id
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	//delete user by id
	@DeleteMapping("/{userId}")
	public void deleteById(@PathVariable("userId") Long id) {
		this.userService.deleteById(id);
	}
	
	
//	@ExceptionHandler(UserFoundException.class)
//	public ResponseEntity<?>exceptionHandler(UserFoundException ex){
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
}
