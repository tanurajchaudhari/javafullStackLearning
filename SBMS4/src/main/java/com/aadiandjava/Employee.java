package com.aadiandjava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
//	@Value("${:101}")
//	private int id;
//	@Value("${:Ram}")
//	private String name;
//	@Value("${:100000}")
//	private double  salary;
	
	@Value("${employee.id}")
	private String id;
	@Value("${employee.name}")
	private String name;
	@Value("${employee.salary}")
	private String salary;
	public Employee(String id, String name, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public void showEmp() {
		System.out.println("ID  :  "+id);
		System.out.println("Name  :  "+name);
		System.out.println("Salary  :  "+salary);

		
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

}
