package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WelcomeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeApiApplication.class, args);
	}

}
