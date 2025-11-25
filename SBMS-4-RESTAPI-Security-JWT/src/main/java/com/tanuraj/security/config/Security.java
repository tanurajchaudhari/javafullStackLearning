package com.tanuraj.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tanuraj.service.CustomUserDetailsService;
import com.tanuraj.service.JWTAuthFilter;

@Configuration
@EnableWebSecurity
public class Security {
	@Autowired
	CustomUserDetailsService customerUSerDetailsService;
	@Autowired
	JWTAuthFilter authFilter;
	
	@Bean 
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticateUser() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(customerUSerDetailsService);
		provider.setPasswordEncoder(encode());
		
		return provider;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception
	{
		return auth.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		http.csrf(x->x.disable())
		  .authorizeHttpRequests(
			auth->auth.requestMatchers("/save","/login").permitAll()
			.anyRequest()
			.authenticated())
		    .httpBasic(Customizer.withDefaults())
		    .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		    
		return http.build();
	}

}
