package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@GetMapping
	public String GreetMsg() {
		String msg="GoodAfternoon";
		return msg;
	}
}
