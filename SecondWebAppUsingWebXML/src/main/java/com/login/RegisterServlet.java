package com.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().print("<h2 style='color:green'>register sucessfully</h2> ");
		//System.out.println("Register servlet service method ");
		req.getRequestDispatcher("tanuraj.html").include(req, resp);
	}
}
