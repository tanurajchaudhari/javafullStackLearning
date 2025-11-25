package com.controller;

import java.util.ArrayList;

import com.entity.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	
	EmployeeService service=new EmployeeService();
	public String insertEmp(Employee employee) {
		String msg = service.insertEmp(employee);
		return msg;
	}
	
	public String insertMultiEmp(ArrayList<Employee> employees) {
		String msg = service.insertMultiEmp(employees);
		return msg;
	}
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = service.getAllEmployees();
		return employees;
	}
	public Employee getEmployeeById(int id) {
		Employee employee = service.getEmployeeById(id);
		return employee;
		
	}
	public String updateEmployee(Employee employee) {
		return service.updateEmployee(employee);
	}
	public String deleteEmployee(int id) {
		return service.deleteEmployee(id);
	}
}
