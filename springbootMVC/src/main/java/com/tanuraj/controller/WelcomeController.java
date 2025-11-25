package com.tanuraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomePage() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("welcome");
		mav.addObject("msg","welcome!  i am tanuraj");
		return mav;
	}
	@GetMapping("/greet")
	public ModelAndView getGreetPage() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("greet");
		mav.addObject("msg","hello greet");
		return mav;
	}

}
