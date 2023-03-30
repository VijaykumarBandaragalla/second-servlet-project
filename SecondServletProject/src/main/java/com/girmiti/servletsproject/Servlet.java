package com.girmiti.servletsproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
		String id = req.getParameter("id");
		int eid=Integer.parseInt(id);
		String nm = req.getParameter("nm");
		String sl = req.getParameter("sl");
		int esal = Integer.parseInt(sl);
		PrintWriter out =resp.getWriter();
		
		out.println("<html><body bgcolor='orange'><h1>" +
				"conrgrats your data is recorded Sucessfully "+ id +"</h1></body></html>");
				out.flush();
		Connection con = null;
		PreparedStatement pstmt = null;
		String query="insert into girmiti.emp values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&pasword=root");
			pstmt = con.prepareStatement(query);
			System.err.println("set value for place holder");
			pstmt.setInt(1, eid);
			pstmt.setString(2, nm);
			pstmt.setInt(3, esal);
		}
		catch(ClassNotFoundException | SQLException e){
			
		}
	}
	
}
