package com.aadi.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.aadi.entity.Employee;
import com.aadi.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")
public class getAlEmployees extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in gae class");
		EmployeeService service=new EmployeeService();
		ArrayList<Employee> employees = service.getAllEmp();
		if(employees!=null) {
			System.out.println("employees have data");
		}else {
			System.out.println("employees dont have data");
		}
		
		req.setAttribute("employees", employees);
		req.getRequestDispatcher("employees.jsp").forward(req,resp);
		
	}

}
