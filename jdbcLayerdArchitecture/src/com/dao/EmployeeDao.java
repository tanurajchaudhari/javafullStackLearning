 package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Employee;
import com.utility.DBConnection;

public class EmployeeDao {
	
	public  String insertEmployee(Employee employee) {
		         Connection con = DBConnection.jdbcConnection();
		try {
			//Query parameter
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			pst.setInt(1,employee.getId());
			pst.setString(2,employee.getName());
			pst.setDouble(3,employee.getSalary());
			pst.setString(4,employee.getDep());
			
			pst.executeUpdate();      //Insert   ,Update,  Delete
			System.out.println("Data inserted");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "Employee inserted succesfull ";
	}
	

	public  String insertMultipleEmployee(ArrayList<Employee> employees) {
		         Connection con = DBConnection.jdbcConnection();
		try {
			//Query parameter
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			for(Employee employee:employees) {
			pst.setInt(1,employee.getId());
			pst.setString(2,employee.getName());
			pst.setDouble(3,employee.getSalary());
			pst.setString(4,employee.getDep());
			
			pst.executeUpdate();  //Insert   ,Update,  Delete
			}
			System.out.println("Data inserted");
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "Employees inserted succesfull ";
	}

	public  ArrayList<Employee> getAllEmployees() {	
		         Connection con = DBConnection.jdbcConnection();
		         ArrayList<Employee>employees=new ArrayList<Employee>();       
		try {
			//Query parameter
			PreparedStatement pst = con.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			   int id =	rs.getInt("id");
			   String name=rs.getString("name");
			   double salary=rs.getDouble("salary");
			   String dep=rs.getString("dep");
			   Employee employee=new Employee(id,name,salary,dep);
			   employees.add(employee);  
			}		
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employees;
	}
	
	public  Employee getEmployeeById(int id) {	
        Connection con = DBConnection.jdbcConnection();
          
        Employee employee=null;
          try {
	        //Query parameter
	         PreparedStatement pst = con.prepareStatement("select * from employee where id=?");
	         pst.setInt(1,id);
	         ResultSet rs = pst.executeQuery();
	         while(rs.next()) {
	             int id1 =	rs.getInt("id");
	             String name=rs.getString("name");
	             double salary=rs.getDouble("salary");
	             String dep=rs.getString("dep");
	              employee=new Employee(id1,name,salary,dep);
	             
	        }		
        }catch (SQLException e) {
	
	        e.printStackTrace();
       }
      return employee;
   }
	
	public  String updateEmployee(Employee employee) {	
        Connection con = DBConnection.jdbcConnection();
          try {
	        //Query parameter
	         PreparedStatement pst = con.prepareStatement("update employee set name=?,salary=?,dep=? where id=?");
	         pst.setString(1,employee.getName());
	         pst.setDouble(2,employee.getSalary());
	         pst.setString(3,employee.getDep());
	         pst.setInt(4,employee.getId());
	         pst.executeUpdate();
	        
	        		
        }catch (SQLException e) {
	
	        e.printStackTrace();
       }
      return "Employee updated Successfully";
   }
	
	
	public  String deleteEmployee(int id) {	
        Connection con = DBConnection.jdbcConnection();
          try {
	        //Query parameter
	         PreparedStatement pst = con.prepareStatement("delete from employee where id=?");
	         pst.setInt(1,id);
	 
	         pst.executeUpdate();
	        
	        		
        }catch (SQLException e) {
	
	        e.printStackTrace();
       }
      return "Employee deleted Successfully";
   }
	
	public static void main(String[] args) {
//		Employee e=new Employee();
//		e.setId(1);
//		e.setName("Tanuraj");
//		e.setSalary(100000);
//		e.setDep("cs");
//		new EmployeeDao().insertEmployee(e);
	}

	
//	public void createTable() {
//		Connection con=DBConnection.jdbcConnection();
//		
//		try {
//			Statement statement = con.createStatement();
//			statement.execute("create table employee(id int, name varchar(40),salary double,dep varchar(30))");
//			System.out.println("Table is created");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		
//	}
//	public static void main(String []args) {
//		new EmployeeDao().createTable();
//	}

}
