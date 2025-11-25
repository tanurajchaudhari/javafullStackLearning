package com.Tanuraj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	@Autowired
	Environment env;
	
	@GetMapping("/greet")
	public String greet() {
		String port = env.getProperty("server.port");
		return "second app in running at port :- "+port;
	}

}
