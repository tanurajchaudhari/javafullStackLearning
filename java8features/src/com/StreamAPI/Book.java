package com.StreamAPI;

public class Book {
       
	String bkname;
	float bkPrice;
	public Book(String bkname, float bkPrice) {
		super();
		this.bkname = bkname;
		this.bkPrice = bkPrice;
	}
	@Override
	public String toString() {
		return "Book [bkname=" + bkname + ", bkPrice=" + bkPrice + "]";
	}
	
}
