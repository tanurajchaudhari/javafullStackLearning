package com.aadiandjava.exception;


import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Response> handleException(Exception e){
		Response response= new Response();
		response.setMsg(e.getMessage());
		response.setExcCode("EXP123");
		response.setDate(LocalDate.now());
		
		 return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
