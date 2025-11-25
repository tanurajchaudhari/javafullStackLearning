package com.tanuraj.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//check the Token
@Component
public class JWTAuthFilter extends OncePerRequestFilter {
	 private final JWTService jwtService ;
	    private final UserDetailsService userDetailsService;

	    public JWTAuthFilter(JWTService jwtService, UserDetailsService userDetailsService) {
	        this.jwtService = jwtService;
	        this.userDetailsService = userDetailsService;
	    }

	    @Override
	    protected void doFilterInternal(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain filterChain)
	            throws ServletException, IOException, java.io.IOException {

	        final String authHeader = request.getHeader("Authorization");
	        final String jwt;
	        final String username;

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            filterChain.doFilter(request, response);
	            return;
	        }

	        jwt = authHeader.substring(7);
	        username = jwtService.extractUsername(jwt);

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	            if (jwtService.isTokenValid(jwt, userDetails.getUsername())) {
	                UsernamePasswordAuthenticationToken authToken =
	                        new UsernamePasswordAuthenticationToken(
	                                userDetails, null, userDetails.getAuthorities());

	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }
	        filterChain.doFilter(request, response);
	    }
}
