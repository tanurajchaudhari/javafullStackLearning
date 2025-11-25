package com.aadiandjava.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aadiandjava.Dto.UserDto;
import com.aadiandjava.entity.Order;
import com.aadiandjava.entity.User;
import com.aadiandjava.exception.UserNotfoundException;
import com.aadiandjava.repo.UserRpository;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserRpository urepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable int id) {
		Order order=restTemplate.getForObject("http://localhost:9090/order/"+id, Order.class);
		 
		 Optional<User> byId = urepository.findById(id);
		 if(byId.isPresent()) {
			 User user = byId.get();
			 UserDto dto = new UserDto();
			 dto.setId(user.getId());
			 dto.setEmail(user.getEmail());
			 dto.setUsername(user.getUsername());
			 dto.setMobileNo(user.getMobileNo());
			 dto.setOrder(order);
			 return new ResponseEntity<UserDto>(dto,HttpStatus.OK);
		 }
		 throw new UserNotfoundException("User No Found with id : "+id);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUser1(@PathVariable int id) {
		 
		 Optional<User> byId = urepository.findById(id);
		 if(byId.isPresent()) {
			 User user = byId.get();
			 UserDto dto = new UserDto();
			 dto.setId(user.getId());
			 dto.setEmail(user.getEmail());
			 dto.setUsername(user.getUsername());
			 dto.setMobileNo(user.getMobileNo());
		
			 return new ResponseEntity<UserDto>(dto,HttpStatus.OK);
		 }
		 throw new UserNotfoundException("User No Found with id : "+id);
	}
}
