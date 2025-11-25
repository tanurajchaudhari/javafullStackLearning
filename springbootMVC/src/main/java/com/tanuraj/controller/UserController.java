package com.tanuraj.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/users")
	public String getUsers(Model model) {
		model.addAttribute("users",Arrays.toString(new String[] {"chetan","rahul","sameer"}) );
		 return "users";
	}
	
	@GetMapping("/names")
	public String getNames(Model model) {
		model.addAttribute("names",Arrays.asList("Bhushan,Durvesh,Ajinkya"));
		return "users";
	}
}
