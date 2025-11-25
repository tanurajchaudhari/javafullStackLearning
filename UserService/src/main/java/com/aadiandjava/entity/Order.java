package com.aadiandjava.entity;

import lombok.Data;

@Data
public class Order {
	private int orderId;
	private String productName;
	private Double productprice;
	private int productQyt;
}
