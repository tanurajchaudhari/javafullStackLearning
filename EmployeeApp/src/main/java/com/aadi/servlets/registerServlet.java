package com.aadi.servlets;

import java.io.IOException;

import com.aadi.entity.Employee;
import com.aadi.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class registerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Method called ");
		EmployeeService service=new EmployeeService();
		resp.setContentType("text/html");
	    String name=	req.getParameter("name"); 
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String city=req.getParameter("city");
		String gender=req.getParameter("gender"); 
		
		Employee employee=new Employee(name,email,password,city,gender);
		String msg = service.insertEmp(employee);
		//HTML
		//resp.getWriter().print("<h3 style='color:green'>"+msg+"</h3>");
		
		req.setAttribute("message", msg);
		
		req.getRequestDispatcher("index.jsp").include(req,resp);
		 
		
		
	}
}
