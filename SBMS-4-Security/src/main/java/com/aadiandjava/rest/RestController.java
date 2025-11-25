package com.aadiandjava.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	//admin
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to rest controller";
	}
    // user
	@GetMapping("/wish")
	public String wish() {
		return "What is your wish ";
	}
	// admin,user
	@GetMapping("/contact")
	public String contact() {
		return "8600169179";
	}
     //for only admin
	@GetMapping("/address")
	public String address() {
		return "sortapwadi";
	}
	@GetMapping("/public")
	public String getPublic() {
		return "Hello public !!!";
	}

}
