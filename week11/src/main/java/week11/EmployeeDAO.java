package week11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDAO {
	
	//THis Dao has all crud methods
	public int registerEmployee(EmployeeModel employee) throws ClassNotFoundException{
		 Connection con;
		 int rs;
		    try{
		    Class.forName("com.mysql.jdbc.Driver");
		    String dburl = "jdbc:mysql://localhost:3306/week11";
			String uid = "root";
			String password = "root";
			con = DriverManager.getConnection(dburl,uid,password);
			System.out.println(con.isClosed());
			
			String sql = "Insert into employee values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1,employee.getFirstname());
			pst.setString(2,employee.getLastname());
			pst.setString(3,employee.getUsername());
			pst.setString(4,employee.getPassword());
			pst.setString(5,employee.getAddress());
			pst.setString(6,employee.getContact());
			
			
			
			rs = pst.executeUpdate();	
			
		    }
		    catch(Exception ex){
		    	ex.printStackTrace();
		    }
		    
		
		return 0;
	}

}
