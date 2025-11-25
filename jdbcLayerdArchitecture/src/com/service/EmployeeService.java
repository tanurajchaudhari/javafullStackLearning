package com.service;

import java.util.ArrayList;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeService {
	EmployeeDao dao=new EmployeeDao();
	public  String insertEmp(Employee employee) {
	
		return dao.insertEmployee(employee);
	}
	public  String insertMultiEmp(ArrayList<Employee> employees) {
		 
		return dao.insertMultipleEmployee(employees);
	}
	public ArrayList<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();;
	}
	public Employee getEmployeeById(int id) {
		Employee employee = dao.getEmployeeById(id);
		if(employee==null) {
			throw new EmpployeeNotFoundException("Employee not found for id :- "+id);
		}
		return employee;
	}
	public String updateEmployee(Employee employee) {
		 String msg = dao.updateEmployee(employee);
//		 if(msg==null) {
//			 throw new EmpployeeNotFoundException("Employee not found for id :- "+employee.getId());
//		 }
		 return msg;
	}
	public String deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

}
