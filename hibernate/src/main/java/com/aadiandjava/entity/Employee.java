package com.aadiandjava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee_details")
public class Employee {
	@Id
	@Column(name="employee_id")
	int id;
	@Column(name="employee_name")
	String name;
	@Column(name="empoyee_department")
	String dep;
	@Column(name="employee_salary")
	double sal;
	

}
