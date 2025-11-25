package com.aadiandjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadiandjava.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

	//findBy
	List<Employee> findByName(String name);
	
	List<Employee> findByDep(String dep);
     
	//List<Employee> findBySalary(Double salary);
	
	List<Employee> findByCity(String city);
	
	List<Employee> findByGender(String gender);
	
	List<Employee> findByNameOrDep(String name, String dep);

	List<Employee> findByNameAndDep(String name, String dep);

	List<Employee> findBySalaryGreaterThan(double salary);

	List<Employee> findByNameStartingWith(String s);
    
	List<Employee> findByNameEndingWith(String s);

	List<Employee> findByNameContains(String s);

}
