package com.exam.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private String authority; 
	public Authority(String authority) {
		super();
		this.authority = authority;
		System.err.println("is there authority problem "+authority);
	}
	@Override
	public @Nullable String getAuthority() {
		
		return this.authority;
	}
	

}
