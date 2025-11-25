package com.aadiandjava.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice  // if exception will occure IOC will invoke this class
public class EXceptionHandler {
	
	//REsponseEntity== it is class in Spring
	@ExceptionHandler
	public ResponseEntity<Response> handleException(Exception e) {
  
		Response response=new Response();
		response.setMsg(e.getMessage());
		response.setDatetime(LocalDateTime.now());
		response.setExceptioncode("EX10startfrom 404");
		
		return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
