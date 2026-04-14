package com.fitness.gateway.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final WebClient userServiceWebClient;
    public  Mono<Boolean> validateUser(String userId) {
    	log.info("Calling User Service for {} : ",userId);
    	
    		return userServiceWebClient.get()
        			.uri("/api/users/{userId}/validate",userId)
        			.retrieve()
        			.bodyToMono(Boolean.class)
        			.onErrorResume(WebClientResponseException.class,e->{
        				if(e.getStatusCode()== HttpStatus.NOT_FOUND)
        					return Mono.error(new RuntimeException("User not found : "+userId));
        				else if(e.getStatusCode()== HttpStatus.BAD_REQUEST)
        					return Mono.error(new RuntimeException("Invalid : "+ userId));
        				
        				return Mono.error(new RuntimeException("Invalid : "+ userId));
        			        
        			}); 	
    }
	public Mono<UserResponse> registerUser(RegisterRequest registerRequest) {
		log.info("Calling User Registration  for {}: ",registerRequest.getEmail());
		System.err.println("Calling User Registration  for {}: "+registerRequest.getEmail());
		System.err.println("firstname: "+registerRequest.getFirstName());
		System.err.println("keycloakId: "+registerRequest.getKeycloakId());
    	
		return userServiceWebClient.post()
    			.uri("/api/users/register")
    			.bodyValue(registerRequest)
    			.retrieve()
    			.bodyToMono(UserResponse.class)
    			.onErrorResume(WebClientResponseException.class,e->{
    			    if(e.getStatusCode()== HttpStatus.BAD_REQUEST)
    					return Mono.error(new RuntimeException("Invalid : "+ e.getMessage()));
    				
    				return Mono.error(new RuntimeException("Invalid : "+ e.getMessage()));
    		     
    			});	
	}
}
