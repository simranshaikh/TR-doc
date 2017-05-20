package com.techm.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("++++++INIT INVOKED++++++++++");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("+++++++++++DESTROY INVOKED++++++++++");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("++++++++SERVICE INVOKED+++++++++++");
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<center><h1>welcome to world of servlets !!:) </h1></center>");
	}


	

}
