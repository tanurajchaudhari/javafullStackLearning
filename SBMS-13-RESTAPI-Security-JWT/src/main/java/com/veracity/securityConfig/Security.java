package com.veracity.securityConfig;

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

import com.veracity.service.CustomUserDetailsService;
import com.veracity.service.JWTAuthFilter;

@Configuration
@EnableWebSecurity
public class Security {

	//2.50 LPA 1-> 6 to 7 2 10 12
	
	@Autowired
	JWTAuthFilter authFilter;
	
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception
	{
		return auth.getAuthenticationManager();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticateUser()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(encoder());
		
		return provider;
	}
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception
	{
		http.csrf(x->x.disable())
		   .authorizeHttpRequests(auth->
		   
		   auth.requestMatchers("/save","/login").permitAll()
		   .anyRequest()
		   .authenticated())
		   .httpBasic(Customizer.withDefaults())
		   .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
;
		
		
		return http.build();
	}
}
