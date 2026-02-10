package com.exam.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import com.exam.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity

public class security {
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired	
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean 
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
    
	@Bean
	public DaoAuthenticationProvider authManager() {
		DaoAuthenticationProvider provider
		=new DaoAuthenticationProvider(userDetailsServiceImpl);
		provider.setPasswordEncoder(encode());
		return provider;
	}
	
	@Bean
    public 	AuthenticationManager authMAnager2(AuthenticationConfiguration auth) {
		return  auth.getAuthenticationManager();	
    }
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) {

//	    http.csrf(csrf -> csrf.disable());
//        http.cors(cors->{});
//	   
//	    http.authorizeHttpRequests(auth -> {
//	        auth.requestMatchers("/user/","/generateToken").permitAll();
//
//        auth.requestMatchers("/current-user").authenticated();
//	        auth.anyRequest().authenticated();
//	    })
//	    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//	    .exceptionHandling(ex ->
//        ex.authenticationEntryPoint(unauthorizedHandler)
//        );
//	    http.sessionManagement(session ->
//	        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	    );	   
//	    return http.build();
		
		
		
		
		
		
	    http.csrf(csrf -> csrf.disable())
            .cors(cors->{})
	   
	        .authorizeHttpRequests(auth -> {
	        auth.requestMatchers("/user/","/generateToken").permitAll()

//	        auth.requestMatchers("/current-user").authenticated();
	        .anyRequest().authenticated();
	    })
	    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
	    .exceptionHandling(ex ->
        ex.authenticationEntryPoint(unauthorizedHandler)
        )
	    .sessionManagement(session ->
	        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    );	   
	    return http.build();
	}	
}

