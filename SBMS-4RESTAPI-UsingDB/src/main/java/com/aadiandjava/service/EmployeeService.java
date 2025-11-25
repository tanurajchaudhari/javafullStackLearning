package com.aadiandjava.service;

import java.util.List;
import java.util.Map;

import com.aadiandjava.dto.EmployeeDtoNameAndDep;
import com.aadiandjava.entity.Employee;

public interface EmployeeService {
	String saveEmployee(Employee employee);
	
//	EmployeeDto getById(int id);
	EmployeeDtoNameAndDep getById(int id);
	
	//Update emp 
	String updateEmp(int id, Employee emp);
	//updateDep
	String updateDep(int id,Map<String,String>dep);
	//updateDepartmentAndSalary
	String updateDepAndSal(int id,Map<String,Object>dep);
    //deleteById
	String deleteById(int id);
	//findByName
	List<Employee> findByName(String name);
	List<Employee> getAllEmp();

}
