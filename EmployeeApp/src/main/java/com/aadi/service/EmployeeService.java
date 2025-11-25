package com.aadi.service;

import com.aadi.entity.Employee;

import java.util.ArrayList;

import com.aad.dao.EmployeeDao;
public class EmployeeService {
	EmployeeDao dao=new EmployeeDao();
	public String insertEmp(Employee employee) {
     return dao.insertEmployee(employee);
     	
	}
	public Employee getEmp(String email,String password) {
		return dao.getEmployee(email, password);
	}
	public ArrayList<Employee> getAllEmp(){
		return dao.getAllEmployees();
	}
	
}
