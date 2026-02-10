package com.exam.helper;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("User with this username not found in database");
	}
	public UserNotFoundException(String msg ) {
		super(msg);
	}

}
