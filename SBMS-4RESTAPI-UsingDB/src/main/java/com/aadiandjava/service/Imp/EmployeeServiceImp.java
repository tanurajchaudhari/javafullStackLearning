package com.aadiandjava.service.Imp;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadiandjava.dto.EmployeeDtoNameAndDep;
import com.aadiandjava.entity.Employee;
import com.aadiandjava.exception.EmployeeNotFoundException;
import com.aadiandjava.repo.EmployeeRepository;
import com.aadiandjava.service.EmployeeService;
@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee saved successfully";
	}


//	@Override
//	public EmployeeDto getById(int id) {
//		System.err.println("In employeeServiceImp ");
//		Optional<Employee> opemp = employeeRepository.findById(id);
//		if(opemp.isPresent()) {
//			Employee employee = opemp.get();
//			EmployeeDto empDto=new EmployeeDto();
//			empDto.setId(employee.getId());
//			empDto.setName(employee.getName());
//			empDto.setDep(employee.getDep());
//			empDto.setSalary(employee.getSalary());
//			
//			return empDto;
//		}
//        throw new EmployeeNotFoundException("Employee Not Found with id : - "+ id);
//	}
	
	@Override
	public EmployeeDtoNameAndDep getById(int id) {
		System.err.println("In employeeServiceImp ");
		Optional<Employee> opemp = employeeRepository.findById(id);
		if(opemp.isPresent()) {
			Employee employee = opemp.get();
			EmployeeDtoNameAndDep empDto=new EmployeeDtoNameAndDep();	
			empDto.setName(employee.getName());
			empDto.setDep(employee.getDep());
		
			return empDto;
		}
        throw new EmployeeNotFoundException("Employee Not Found with id : - "+ id);
	}


	@Override
	public String updateEmp(int id, Employee emp) {
		Optional<Employee> existing = employeeRepository.findById(id);
		if(existing.isPresent()) {
			Employee existingEmp = existing.get();
			existingEmp.setDep(emp.getDep());
			existingEmp.setName(emp.getName());
			existingEmp.setSalary(emp.getSalary());
			employeeRepository.save(existingEmp);
		}else {
		
			throw new EmployeeNotFoundException("Employee not found : "+id);
		}
			
		return "Employee UPdate successfully ";
	}


	@Override
	public String updateDep(int id, Map<String, String> dep) {
		Optional<Employee> existing = employeeRepository.findById(id);
		if(existing.isPresent()) {
			Employee employee = existing.get();
			employee.setDep(dep.get("Dep"));
			employeeRepository.save(employee);
		}else {
		
			throw new EmployeeNotFoundException("Employee not found : "+id);
		}
		return "Employee dep UPdated";
	}


	@Override
	public String updateDepAndSal(int id, Map<String, Object> dep) {
		Optional<Employee> existing = employeeRepository.findById(id);
		if(existing.isPresent()) {
			Employee employee = existing.get();
			employee.setDep((String)dep.get("Dep"));
			employee.setSalary((Double)dep.get("Sal"));
			employeeRepository.save(employee);
		}else {
		
			throw new EmployeeNotFoundException("Employee not found : "+id);
		}
		return "Employee Department and salary  update successfully";
	}


	@Override
	public String deleteById(int id) {
		Optional<Employee> existing = employeeRepository.findById(id);
		boolean existsById = employeeRepository.existsById(id);
		if(existsById) {
			employeeRepository.deleteById(id);
		}else {
		
			throw new EmployeeNotFoundException("Employee not found : "+id);
		}
		
		return "Deleted successfully";
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> employees = employeeRepository.findByName(name);
		return employees;
	}


	@Override
	public List<Employee> getAllEmp() {
		
		return employeeRepository.findAll();
	}
	
	

	

}
