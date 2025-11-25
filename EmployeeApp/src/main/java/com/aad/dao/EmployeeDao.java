package com.aad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aadi.DBConnection.JDBCConnection;
import com.aadi.entity.Employee;

public class EmployeeDao {
	
	public String insertEmployee(Employee employee) {
		
		Connection dbConnection = JDBCConnection.getDbConnection();
		
		try {
			PreparedStatement pst = dbConnection.prepareStatement("insert into employees values(?,?,?,?,?)");
			pst.setString(1,employee.getName());
			pst.setString(2,employee.getEmail());
			pst.setString(3,employee.getPassword());
			pst.setString(4,employee.getCity());
			pst.setString(5,employee.getGender());
			
			pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "Employee save Successfully";
	}
	
	 public Employee getEmployee(String email,String password)  {
		 Connection conn = JDBCConnection.getDbConnection();
		 Employee employee=null;
		 try {
		      PreparedStatement pst = conn.prepareStatement("select * from employees where email=? and password=?");
		      pst.setString(1,email);
		      pst.setString(2,password);
		      System.out.println("work before executequery");
		      ResultSet rs = pst.executeQuery();
		      System.out.println("rs :- "+rs);
		      while(rs.next()) {
		    	  System.out.println("rs.next	");
		    	 String name= rs.getString(1);
		    	 String email1= rs.getString(2);
		    	 String password1=rs.getString(3);
		    	  String city=rs.getString(4);
		    	 String gender= rs.getString(5);
		    	 employee=new Employee(name,email1,password1,city,gender);
		    	 
		    	 
		    	 
		      }
		      
		 
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return employee;
		 
	 }
	 
	 public ArrayList<Employee> getAllEmployees(){
		 Connection conn = JDBCConnection.getDbConnection();
		 ArrayList<Employee>employees=new ArrayList<Employee>();
		 Employee employee=null;

		 try {
		      PreparedStatement pst = conn.prepareStatement("select * from employees");		      
		      ResultSet rs = pst.executeQuery(); 
		      
		      
		      while(rs.next()) {
		    	
		    	 String name= rs.getString(1);
		    	 String email1= rs.getString(2);
		    	 String password1=rs.getString(3);
		    	  String city=rs.getString(4);
		    	 String gender= rs.getString(5);
		    	 employee=new Employee(name,email1,password1,city,gender);
		    	 employees.add(employee);
		    	 
		      }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return employees;
		 
	 }


}
