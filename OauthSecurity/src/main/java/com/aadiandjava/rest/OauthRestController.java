package com.aadiandjava.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthRestController {
	
	//http://localhost:8080
	@GetMapping
	public String welcome() {
		return "ata avghad zala";
	}

}
