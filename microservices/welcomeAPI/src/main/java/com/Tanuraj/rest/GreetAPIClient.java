package com.Tanuraj.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="http://localhost:9090",name="GreetAPI")
public interface GreetAPIClient {
	@GetMapping("/greet")
	public String invokeGreetAPI();

}
