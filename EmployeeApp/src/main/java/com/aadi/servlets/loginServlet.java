package com.aadi.servlets;

import java.io.IOException;

import com.aadi.entity.Employee;
import com.aadi.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		EmployeeService service=new  EmployeeService();
		Employee loggedInEmployyee = service.getEmp(email, password);
		System.out.println(loggedInEmployyee);
		
		if(loggedInEmployyee!=null) {
			req.setAttribute("employee", loggedInEmployyee);
			req.setAttribute("name", loggedInEmployyee.getName());
			req.getRequestDispatcher("profile.jsp").forward(req,resp);
		}else {
			req.setAttribute("msg", "Incorrect Email or password");
            req.getRequestDispatcher("login.jsp").include(req,resp);
		}
		
		
		
	}

}
