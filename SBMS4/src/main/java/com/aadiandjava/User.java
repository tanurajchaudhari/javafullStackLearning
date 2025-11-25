package com.aadiandjava;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
	
    public User() {
	
    	System.out.println("User Constructor");
    }
}
