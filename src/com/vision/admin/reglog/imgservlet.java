package com.vision.admin.reglog;

import java.io.*;

import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imgservlet
 */
@WebServlet("/imgservlet")
public class imgservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
PrintWriter out=response.getWriter();
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","system");
PreparedStatement ps=con.prepareStatement("select * from imgtable");
ResultSet rs=ps.executeQuery();
if(rs.next())
{
	Blob b=rs.getBlob(1);
	byte[] bb=b.getBytes(1, (int) b.length());
	FileOutputStream fos=new FileOutputStream("E:/test/img.jpg");
	fos.write(bb);
	fos.close();
	out.print("<div><img src=\"E:/test/img.jpg\"></div>");
	System.out.println("Image written to file");
}
else
{
	System.out.println("image not displayed");
}

}
catch(Exception e)
{
	System.out.println(e);
}



		
	}

}
