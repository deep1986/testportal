package com.seh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("emailid");
		System.out.println(userName);
		String password=request.getParameter("password");
		System.out.println(password);
		Connection con;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_URL="jdbc:mysql://localhost/seh";
			String username="root";
			String dbpassword="root";
			con =	DriverManager.getConnection(db_URL,username,dbpassword);
			Statement stmt= con.createStatement();
			String QueryString = "SELECT * from student where emailid='"+userName+"'";
			ResultSet rs = stmt.executeQuery(QueryString);
			
			rs.next();
			if(rs.getString("password").equals(password)) {
				System.out.println("Success"); 
				request.getRequestDispatcher("/dashboard.jsp").forward(request, response);	
			}
			else {
				System.out.println("Failed"); 
				request.setAttribute("results", "Login Failed : Wrong UserName/Password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
     	}
		catch(Exception e)
		{
			request.setAttribute("results", "Login Failed : Wrong UserName/Password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//e.printStackTrace();
			
		}
	}

}
