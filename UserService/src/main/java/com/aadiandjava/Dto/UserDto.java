package com.aadiandjava.Dto;

import com.aadiandjava.entity.Order;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer id;
	private String username;
	private String email;
	private String mobileNo;
	private Order order;
	

}
