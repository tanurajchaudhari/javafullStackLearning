package com.exam.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
//	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String name = "Authorization";
//		final String requestTokenHeader = request.getHeader(name);
//		System.err.println("Token : "+requestTokenHeader);
//		String username=null;
//		String jwtToken=null;
//		
//		if(requestTokenHeader!=null  && requestTokenHeader.startsWith("Bearer ")) {
//			//yes 
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//			username=this.jwtUtil.extractUsername(jwtToken);
//			}catch(ExpiredJwtException e) {
//				e.printStackTrace();
//				System.err.println("jwt Token has expired");
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//		}else {
//			System.err.println("Invalid Token, Not start with Bearer ");
//		}
//		
//		//validate the token
//		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
//			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//			if(this.jwtUtil.validateToken(jwtToken)) {
//				//                
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
//			=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//				
//				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//				
//			}
//		}else {
//			System.err.println("Token is not valid...");
//		}
//		
//		filterChain.doFilter(request, response);		
	

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.err.println("REQUEST URI = " + request.getRequestURI());
		
		
		final String authHeader = request.getHeader("Authorization");
          System.err.println("authHeader : "+authHeader);
		// 1️⃣ No token → continue
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		// 2️⃣ Extract token
		String token = authHeader.substring(7);
		if (!jwtService.validateToken(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		// 4️⃣ Extract username
		String username = jwtService.extractUsername(token);

		// 5️⃣ Set authentication only if not already set
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authToken 
			= new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());

			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(authToken);
		}

// 6️⃣ Continue filter chain
		filterChain.doFilter(request, response);
	
	
	
	}

}
