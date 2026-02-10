package com.tanuraj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tanuraj.entity.User;
import com.tanuraj.repo.UserRepository;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> byUsername = userRepository.findByUsername(username);
		if(byUsername.isPresent()) {
			User user = byUsername.get();
			return  org.springframework.security.core.userdetails.
					User.withUsername(user.getUsername())
					.password(user.getPassword())
					.roles(user.getRole()).build();
		}
		
		throw new RuntimeException("Not found ");
	}


	

}
