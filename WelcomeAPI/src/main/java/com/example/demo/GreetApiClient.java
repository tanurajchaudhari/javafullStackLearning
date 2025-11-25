package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="http://localhost:9090",name="GreetAPI")
public interface GreetApiClient {
	
	
	@GetMapping
	String getGreeetApiResponse();

	
}
