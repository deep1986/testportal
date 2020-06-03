package com.seh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetails
 */
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		System.out.println(name);
		String emailid=request.getParameter("emailid");
		System.out.println(emailid);
		String stdudent_class=request.getParameter("class");
		System.out.println(stdudent_class);
		String phoneno=request.getParameter("phonenumber");
		System.out.println(phoneno);
		String address=request.getParameter("address");
		System.out.println(address);
		Connection con;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_URL="jdbc:mysql://localhost/seh";
			String username="root";
			String password="root";
			con =	DriverManager.getConnection(db_URL,username,password);

			PreparedStatement ps=con.prepareStatement("insert into student (student_id,name,emailid,class,phoneno,address) values(null,?,?,?,?,?)"); 
			ps.setString(1,name);
			ps.setString(2,emailid);
			ps.setString(3,stdudent_class);
			ps.setLong(4,Long.parseLong(phoneno));
			ps.setString(5,address);
			ps.executeUpdate();
     	}
		catch(Exception e)
		{
			
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
