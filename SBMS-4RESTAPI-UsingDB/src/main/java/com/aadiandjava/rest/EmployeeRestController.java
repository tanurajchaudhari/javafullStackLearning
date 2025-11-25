package com.aadiandjava.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.dto.EmployeeDtoNameAndDep;
import com.aadiandjava.entity.Employee;
import com.aadiandjava.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;
	
//	@PostMapping("/save")
//	public String saveEmployee(@RequestBody Employee employee) {
//		
//		String msg=employeeService.saveEmployee(employee);
//		return msg;
//	}

	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		
		String msg=employeeService.saveEmployee(employee);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}

//	@GetMapping("/byid/{id}")
//	public ResponseEntity<EmployeeDto> getById(@PathVariable int id) {
//		System.err.println("In employerestcontroller");
//		EmployeeDto employee = employeeService.getById(id);
//		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
//	}
//	@GetMapping("/byid2")
//	public ResponseEntity<EmployeeDto> getById2(@RequestParam int id) {
//		System.err.println("In employerestcontroller");
//		EmployeeDto employee = employeeService.getById(id);
//		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
//	}
	@GetMapping("/byid2")
	public ResponseEntity<EmployeeDtoNameAndDep> getById2(@RequestParam int id) {
		System.err.println("In employerestcontroller");
		EmployeeDtoNameAndDep employee = employeeService.getById(id);
		return new ResponseEntity<EmployeeDtoNameAndDep>(employee,HttpStatus.OK);
	}
	
	//update method
	//localhost:8080/employee/update/1
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee employee){
	
		String msg = employeeService.updateEmp(id,employee);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	//localhost:8080/employee/update/dep/1
	@PatchMapping("/update/dep/{id}")
	public ResponseEntity<String> updateDep(@PathVariable int id, @RequestBody Map<String,String>dep){
		
		String msg = employeeService.updateDep(id,dep);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@PatchMapping("/update/dep/salary/{id}")
	public ResponseEntity<String> updateDepAndSalary(@PathVariable int id,@RequestBody Map<String,Object>dep){
		
        String msg = employeeService.updateDepAndSal(id,dep);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteById(@PathVariable int id){
		String msg = employeeService.deleteById(id);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		 
		
	}
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Employee>> findByName(@PathVariable String name){
		List<Employee> employees = employeeService.findByName(name);
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> findAll(){
		System.err.println("in restcontroller");
		List<Employee> employees = employeeService.getAllEmp();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
}
