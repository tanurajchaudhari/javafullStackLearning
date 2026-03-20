package com.fitness.userservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request ){
		return ResponseEntity.ok(userService.register(request));
	}
	
	@GetMapping("/{userId}") 
	public  ResponseEntity<UserResponse>getUserProfile(@PathVariable("userId")String userId){
		return ResponseEntity.ok(userService.getUserProfile(userId));
	}
	
	//validate the users 
	@GetMapping("/{userId}/validate") 
	public  ResponseEntity<Boolean>validateUser(@PathVariable("userId")String userId){
		System.err.println("in user controller for validate the user");
		return ResponseEntity.ok(userService.existsByUser(userId));
	}
}
