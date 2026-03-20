package com.fitness.userservice.services;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repo.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	
	private final UserRepository userRepository;

	public  UserResponse register(RegisterRequest request) {
		
		if(this.userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already existed");
		}

		User user=new User();
		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());
		User savedUser = this.userRepository.save(user);
		
		UserResponse userResponse = new UserResponse();
		userResponse.setFirstName(savedUser.getFirstName());
		userResponse.setLastName(savedUser.getLastName());
		userResponse.setEmail(savedUser.getEmail());
		userResponse.setId(savedUser.getId());
		userResponse.setPassword(savedUser.getPassword());
		userResponse.setCreatedAt(savedUser.getCreatedAt());
		userResponse.setUpdatedAt(savedUser.getUpdatedAt());
		
		return userResponse;
		
	}

	public  UserResponse getUserProfile(String userId) {
		    User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
			UserResponse userResponse = new UserResponse();
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setEmail(user.getEmail());
			userResponse.setId(user.getId());
			userResponse.setPassword(user.getPassword());
			userResponse.setCreatedAt(user.getCreatedAt());
			userResponse.setUpdatedAt(user.getUpdatedAt());
			return userResponse;
	}

	public Boolean existsByUser(String userId) {
		System.err.println("in ExistsByUserId in user service");
		return userRepository.existsById(userId);
	}
}
