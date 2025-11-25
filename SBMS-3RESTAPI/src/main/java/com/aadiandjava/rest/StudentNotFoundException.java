package com.aadiandjava.rest;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
