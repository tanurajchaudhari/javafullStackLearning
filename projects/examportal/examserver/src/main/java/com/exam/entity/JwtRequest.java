package com.exam.entity;

public class JwtRequest {
	String username;
	String password;
	public JwtRequest(String username, String password) {
		super();
		this.username = username; 
		this.password = password;
		
		System.err.println("in constructor of JwtRequest");
		System.err.println(username);
		System.err.println(password);
	}
	public String getUsername() {
		return username;
	}
	public JwtRequest() {
		super();
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
