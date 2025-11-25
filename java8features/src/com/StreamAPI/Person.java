package com.StreamAPI;

public class Person {

	String name;
	String city;
	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + "]";
	}
	
}
