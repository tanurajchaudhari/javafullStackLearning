package com.tanuraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Welcomecontroller {

	@GetMapping("/welcome")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	public  ModelAndView getWelcomePage() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("welcome");
		return mav;
	}
}
