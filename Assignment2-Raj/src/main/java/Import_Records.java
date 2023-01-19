
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


@WebServlet("/import_Records")
public class Import_Records extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       

    
    public void init() {
    	try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		String dburl = "jdbc:mysql://localhost:3306/as_2_raj";
    		String uid = "root";
    		String password = "root";
    		con = DriverManager.getConnection(dburl,uid,password);
    		
    		
    		System.out.println(con.isClosed());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] names = 
			{"Raj", "Suraj", "Daksh", "Vimarsh", "Hemant", "vidhi", "Nevil", "divya", "priya", "paul"};
		String dept = "IT";
		String[] emp_job = 
			{"President", "CEO", "Senior Manager", "CTO", "assitant Manager", "Project Manager", "Full Stack Developer", "Software Developer", "Senior Developer", "Junior Developer"};
		PrintWriter output = response.getWriter();
		
		for (int i=0; i < 10; i++) {
			String sqlinsert = "Insert into emp(empno,empname,department,empjob) Values (?,?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sqlinsert);
				ps.setString(1, String.valueOf(i));
				ps.setString(2, names[i]);
				ps.setString(3, dept);
				ps.setString(4, emp_job[i]);

				ps.executeUpdate();
				output.println("Employee: " + names[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
