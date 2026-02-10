package com.tanuraj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanuraj.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{

}
