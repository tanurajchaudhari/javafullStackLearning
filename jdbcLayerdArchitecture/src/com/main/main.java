package com.main;

import java.util.ArrayList;

import com.controller.EmployeeController;
import com.entity.Employee;
import com.service.EmpployeeNotFoundException;

public class main {
	
	public static void main(String[] args) {
		EmployeeController controller=new EmployeeController();
		
//		Employee emp1=new Employee(3,"chetan",985684,"devops");
//		Employee emp2=new Employee(4,"swati",85698,"English");
//		Employee emp3=new Employee(5,"Rohan",8495693,"sports");
//		
//		ArrayList<Employee> employees=new ArrayList<Employee>();
//		employees.add(emp1);
//		employees.add(emp2);
//		employees.add(emp3);
		//String msg = controller.insert(emp);
//		String msg=controller.insertMultiEmp(employees);
//		System.out.println(msg);
		
//		ArrayList<Employee> employees = controller.getAllEmployees();
//		for(Employee employee:employees) {
//			System.out.println(employee.getId());
//			System.out.println(employee.getName());
//			System.out.println(employee.getSalary());
//			System.out.println(employee.getDep());
//			System.out.println("====================================================    ");
//		}
//		try {
//		Employee employee = controller.getEmployeeById(6);
//		System.out.println(employee.getId());
//		System.out.println(employee.getName());
//		System.out.println(employee.getSalary());
//		System.out.println(employee.getDep());
//		}catch (EmpployeeNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//		System.out.println(controller.updateEmployee(new Employee(10,"KaranAndArjun",434359,"finanace")));
//		}catch (EmpployeeNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		
		//System.out.println(controller.updateEmployee(new Employee(10,"KaranAndArjun",434359,"finanace")));
		
		System.out.println(controller.deleteEmployee(1));
		
	}
}
