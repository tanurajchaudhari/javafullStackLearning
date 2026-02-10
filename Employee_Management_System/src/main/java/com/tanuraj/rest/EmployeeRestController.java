package com.tanuraj.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanuraj.entity.Employee;
import com.tanuraj.repo.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
    AuthenticationManager authenticationManager;

	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> login(@RequestParam String username, @RequestParam String password) {
		System.err.println(username);
		System.err.println(password);
		
	 try {
		 Authentication authentication=
				 authenticationManager
				 .authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		SecurityContextHolder
		.getContext()
		.setAuthentication(authentication);
		Map<String,String> map=new HashMap<String,String>();
		map.put("Message", "Login Successfuly");
		return ResponseEntity.ok(map);
		}catch (Exception e ) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("Message", "Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(map);
		}
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employees = empRepository.findAll();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult result) {

		if(result.hasErrors()) {
			Map<String,String>response=new HashMap<String,String>();
			result.getFieldErrors().forEach(error ->
			response.put(error.getField(),error.getDefaultMessage())
			);
			return ResponseEntity.badRequest().body(response);		
		}		
		empRepository.save(employee);
		Map<String,String>response=new HashMap<String,String>();
        response.put("message","Employee REgistered Successfully");	
		return  ResponseEntity.ok(response);
	}
}
