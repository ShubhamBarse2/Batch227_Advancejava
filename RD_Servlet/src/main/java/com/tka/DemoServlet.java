package com.tka;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class DemoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		PrintWriter out =  resp.getWriter();
		resp.setContentType("text/html");
		
		if(Uname.equals("ram@gmail.com") && pass.equals("Ram@123")) {
			out.print("<h1>"+"Succssfully Login...."+"</h1>");
			
			RequestDispatcher rd =  req.getRequestDispatcher("profile.jsp");
			rd.include(req, resp);
			
			
		}else {
			out.print("<h1>"+"UNsuccssfully Login...."+"</h1>");
			RequestDispatcher rd =  req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		}
		
		
		
	}
	
}
