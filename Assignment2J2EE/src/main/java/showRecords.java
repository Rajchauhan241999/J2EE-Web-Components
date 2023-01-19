

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showRecords
 */
@WebServlet("/showRecords")
public class showRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showRecords() {
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
		try {
			Statement st = con.createStatement();
			String sqlselect = "Select * from EMP";
			ResultSet rs = st.executeQuery(sqlselect);
			while(rs.next()) {
				output.println(rs.getString("EmpNo") + "\t" + rs.getString("EmpName") + rs.getString("Department") + rs.getString("EmpJob"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
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
