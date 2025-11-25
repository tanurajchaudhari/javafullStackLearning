package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GreetApiClient;

@RestController
public class WelcomeRestController {

//	@Autowired
//	RestTemplate restTemplate; 
	@Autowired
	GreetApiClient apiClient;
	
	@GetMapping("/welcome")
	public String WelcomeMsg() {
	//	String GreetAPIResponse = restTemplate.getForObject("http://localhost:9090", String.class);
		String greeetApiREsponse = apiClient.getGreeetApiResponse();
		String msg="Welcome , We are  learning Microservices ";
		return greeetApiREsponse+msg;
	}
}
