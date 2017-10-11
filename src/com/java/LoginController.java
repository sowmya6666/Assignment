package com.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		
	/*	if(username.equals("admin") && pwd.equals("admin"))
		{
			response.sendRedirect("success.html");
			return;
		}
		else
		{
			response.sendRedirect("error.html");
			return;
		}*/
	
		try {
			
		  // MySQL database connection
			Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");    
        PreparedStatement pst = conn.prepareStatement("Select username,password from user where username=? and password=?");
        pst.setString(1, username);
        pst.setString(2, pwd);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next()) {          
        	response.sendRedirect("success.html");
		return;      
        }else{
        	response.sendRedirect("error.html");
		return;   
        }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  // MySQL database connection

		}
	
	

}
