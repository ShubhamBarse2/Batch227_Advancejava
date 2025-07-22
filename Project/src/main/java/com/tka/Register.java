package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String mobNO = req.getParameter("phone");
		long phoneNO = Long.parseLong(mobNO);
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch227", "root", "root");
			PreparedStatement ps = c
					.prepareStatement("insert into studentinfo(sname,email,password,phoneNo)values(?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setLong(4, phoneNO);
			int set = ps.executeUpdate();

			if (set > 0) {
				out.print("<h1>" + "Registration Successfully..." + "</h1>");
				out.print("<a href=login.html>Login here</a>");
			} else {
				out.print("<h1>" + "Registration UnSuccessfully..." + "</h1>");
				
			}
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
