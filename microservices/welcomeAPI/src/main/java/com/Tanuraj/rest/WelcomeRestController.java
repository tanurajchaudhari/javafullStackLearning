package com.Tanuraj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

@RestController
public class WelcomeRestController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	GreetAPIClient greetApiClient;
//	@Autowired
//	Environment evn;
	
	@GetMapping("/welcome")
	public  String welcome() {
//	   String port = evn.getProperty("server.port");
//		String greetAPIResponse=restTemplate.getForObject("http://localhost:9090/greet", String.class);
		String invokeGreetAPI = greetApiClient.invokeGreetAPI();
		
		return invokeGreetAPI+" Welcome to tanuraj and  his dismanagement with feign client";
	}

}
