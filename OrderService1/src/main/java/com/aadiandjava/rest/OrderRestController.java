package com.aadiandjava.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.entity.Order;
import com.aadiandjava.exception.OrderNotFoundException;
import com.aadiandjava.repo.OrderRepositoy;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	OrderRepositoy orepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable int  id) {
		
		Optional<Order> byId = orepository.findById(id);
		if(byId.isPresent()) {
			Order order =byId.get();
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		}
	     throw new OrderNotFoundException("Order ot found :-"+id);
	}
}
