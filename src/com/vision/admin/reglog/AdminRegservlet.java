package com.vision.admin.reglog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminRegservlet")
public class AdminRegservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String name=request.getParameter("adminname");
		String empid=request.getParameter("adminempid");
		String email=request.getParameter("adminemail");
		String pwd=request.getParameter("adminpwd");
		String confirmpwd=request.getParameter("adminconfirmpwd");
		String mobile=request.getParameter("adminmobile");
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","onlinetest","onlinetest");
			String query="insert into admin_registration values(Test_sequence.nextval,'"+name+"','"+email+"','"+mobile+"','"+empid+"','"+pwd+"','"+confirmpwd+"')";
			PreparedStatement pst=con.prepareStatement(query);
			int row=pst.executeUpdate();
			out.println("User Registered Sucessfully.....");
			out.println("row inserted..."+row);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
