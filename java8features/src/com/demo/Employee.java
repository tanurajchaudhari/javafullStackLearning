package com.demo;

public class Employee {
	String name;
	String city;
	String profile;
	public Employee(String name, String city, String profile) {
		super();
		this.name = name;
		this.city = city;
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", profile=" + profile + "]";
	}
	 

}
