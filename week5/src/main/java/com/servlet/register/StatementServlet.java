package com.servlet.register;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StatementServlet")
public class StatementServlet extends HttpServlet {
	Connection con;
	
    public void init() {
    	try {
    		//Step 1: Loading database driver for mysql (connector/j)  		
    		Class.forName("com.mysql.jdbc.Driver");
    		//Step 2:  connect to the database
    		String dburl = "jdbc:mysql://localhost:3306/Oct5_rr";
    		String uid = "root";
    		String password = "root";
    		con = DriverManager.getConnection(dburl, uid, password);
    		
    		System.out.println(con.isClosed());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = "User5";
		String password = "Password5";
		String email = "Email5";
		
		// 3rd step: creating sql query and execute it
		try {
			Statement st = con.createStatement();
			String sqlinsert = "INSERT INTO Login (Username, Password, Email) "
					+ "Values ('"+ uname + "', '"+password+"', '"+email+"')";
			
			st.executeUpdate(sqlinsert);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}

}
