package com.aadiandjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aadiandjava.entity.User;
import com.aadiandjava.repo.UserRepository;
@Service
public class CustomeUserDetailsService implements UserDetailsService {

	// to get user from DB and give to springcontext
	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> op = repository.findByUsername(username);
		if(op.isPresent()) {
			User user = op.get();
			return org.springframework.security.core.userdetails.User
					.withUsername(user.getUsername())
					.password(user.getPassword())
					.roles(user.getRole())
					.build();
		}
		throw new UsernameNotFoundException("USer not fount  username : "+username);
	}

	

}
