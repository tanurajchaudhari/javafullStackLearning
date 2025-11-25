package com.aadiandjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.aadiandjava.service.CustomeUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	CustomeUserDetailsService customUserDetailsService;
	
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//to authenticate(username, password, role) DB user
	@Bean
	public DaoAuthenticationProvider authenticate() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	
	//Springboot enables csrf = Security by default
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->
		   auth.requestMatchers("/product/save").hasRole("ADMIN")
		   .requestMatchers("/product/all").hasAnyRole("ADMIN","USER")
		  .requestMatchers("/auth/**").permitAll()
		  .anyRequest().authenticated())
		  .httpBasic(Customizer.withDefaults())
		  .formLogin(Customizer.withDefaults());
		
				
		
		return http.build();
	}

	
}
