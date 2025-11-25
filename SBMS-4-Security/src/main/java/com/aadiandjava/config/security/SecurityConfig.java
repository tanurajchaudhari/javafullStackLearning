package com.aadiandjava.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService createUser() {
		UserDetails Admin = 
		User
		.withUsername("Ram")
		.password("{noop}Ram&123")
		.roles("ADMIN")
		.build();
		
		
		UserDetails user1 = 
				User
				.withUsername("Aakash")
				.password("{noop}Aakash&123")
				.roles("USER")
				.build();
		
		UserDetails user2 = 
				User
				.withUsername("Sameer")
				.password("{noop}Sameer&123")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(Admin,user1,user2);
	} 
	
//	@Bean
//	public SecurityFilterChain applyCustomSecurity(HttpSecurity http) throws Exception {
//		
//		http.authorizeHttpRequests(auth->
//		  auth.requestMatchers("/welcome","/wish")
//		  .permitAll()
//		  .anyRequest()
//		  .authenticated()
//		
//		
//		)
//		.httpBasic(Customizer.withDefaults())// postman,angular,react
//		.formLogin(Customizer.withDefaults());//brawser
//		return http.build();
//	}

	@Bean
	public SecurityFilterChain applyCustomSecurity(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth->
		  auth.requestMatchers("/welcome","/address")
		  .hasRole("ADMIN")
		  .requestMatchers("/wish")
		  .hasRole("USER")
		  .requestMatchers("/contact")
		  .hasAnyRole("ADMIN","USER")
		  .requestMatchers("/public")
		  .permitAll()
		  .anyRequest()
		  .authenticated()
		
		
		)
		.httpBasic(Customizer.withDefaults())// postman,angular,react
		.formLogin(Customizer.withDefaults());//brawser
		return http.build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
