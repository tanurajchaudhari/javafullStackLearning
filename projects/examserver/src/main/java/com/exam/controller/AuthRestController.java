package com.exam.controller;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtil;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponse;
import com.exam.entity.User;
import com.exam.helper.UserNotFoundException;
import com.exam.service.impl.UserDetailsServiceImpl;

@RestController       
@CrossOrigin(origins = "http://localhost:4200")
public class AuthRestController {
    
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImple;
	
	@PostMapping("/generateToken")                                     
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.err.println(jwtRequest.getUsername()+" : "+jwtRequest.getPassword());
		try {
			
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		}catch(UserNotFoundException e){
			e.printStackTrace();
			throw new Exception("user not found exception");
		}
		// user is authenticated 
		UserDetails userDetails = this.userDetailsServiceImple.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	private void authenticate(String name,String password) throws Exception {	
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));
			
		}catch(DisabledException e) {
			throw new Exception("USER DISABLE "+e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid credentials"+ e.getMessage());
		}
	}
	
	//return the details of current user 
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsServiceImple.loadUserByUsername(principal.getName()));
	}
	
}
