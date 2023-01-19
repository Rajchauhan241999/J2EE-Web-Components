
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class importRecords
 */
@WebServlet("/importRecords")
public class importRecords extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public importRecords() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		String dburl = "jdbc:mysql://localhost:3306/As2_Abhishek";
    		String uid = "root";
    		String password = "Abukalhan";
    		con = DriverManager.getConnection(dburl,uid,password);
    		
    		
    		System.out.println(con.isClosed());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] names = {"Abhishek", "Tom", "Robert", "Johnny", "Ryan", "Reynolds", "Hugh", "Jackman", "Steve", "Chris"};
		String dept = "IT";
		String[] emp_job = {"President", "CEO", "CFO", "CTO", "Senior Manager", "Project Manager", "Full Stack Developer", "Software Developer", "Senior Developer", "Junior Developer"};
		PrintWriter output = response.getWriter();
		
		for (int i=0; i < 10; i++) {
			String sqlinsert = "Insert into EMP(EmpNo, EmpName, Department, EmpJob) Values (?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sqlinsert);
				ps.setString(1, String.valueOf(i));
				ps.setString(2, names[i]);
				ps.setString(3, dept);
				ps.setString(4, emp_job[i]);

				ps.executeUpdate();
				output.println("Added Employee: " + names[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
