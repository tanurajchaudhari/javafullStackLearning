package com.tanuraj.config;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tanuraj.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class Security {
	
	@Autowired
    CustomUserService customUserService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) {
		AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
		auth.userDetailsService(customUserService)
		.passwordEncoder(encoder());
		return auth.build();
	}
	
	private void passwordEncoder(BCryptPasswordEncoder encoder) {
		// TODO Auto-generated method stub
		
	}
	//Authenticate the user 
	//old approach
	public DaoAuthenticationProvider authenticateUser() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOriginPatterns(List.of("http://localhost:4200"));
	    config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
	    config.setAllowedHeaders(List.of("*"));
	    config.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);

	    return source;
	}

	
	
   @Bean
   public SecurityFilterChain chain(HttpSecurity http) {
	   http.cors(Customizer.withDefaults());
	   http.csrf(csrf->csrf.disable());
	   http.authorizeHttpRequests(auth->{
		   auth.requestMatchers("/auth/**","/emp/login").permitAll()
		   .anyRequest()
		   .authenticated();
	   }).formLogin(form->form.disable())
	   .httpBasic(Customizer.withDefaults())
	   .sessionManagement(session->
	   session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
	   return http.build();
   }

}
