

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class insertFormRecords
 */
@WebServlet("/insertFormRecords")
public class insertFormRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertFormRecords() {
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
		PrintWriter output = response.getWriter();
		String emp_number = request.getParameter("emp_number");
		String emp_name = request.getParameter("emp_name");
		String job_title = request.getParameter("job_title");
		String dept = request.getParameter("dept");
		
		
		String sqlinsert = "Insert into EMP(EmpNo,EmpName,Department,EmpJob) Values (?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sqlinsert);
			ps.setString(1, emp_number);
			ps.setString(2, emp_name);
			ps.setString(3, job_title);
			ps.setString(4, dept);

			ps.executeUpdate();
			output.println("Added Employee: " + emp_name + " job_title: " + job_title + " in dept: " + dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			output.println("An Exception occurred, we couldn't process the employee addition to the DB!");
			e.printStackTrace();
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
