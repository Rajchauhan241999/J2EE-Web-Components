import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Logindao {
	
	//THis Dao has all crud methods
	public int registerUser(Loginmodel login) throws ClassNotFoundException{
		 Connection con;
		 int rs;
		    try{
		    Class.forName("com.mysql.jdbc.Driver");
		    String dburl = "jdbc:mysql://localhost:3306/W11_Raj";
			String uid = "root";
			String password = "root";
			
			
			con = DriverManager.getConnection(dburl,uid,password);
			System.out.println(con.isClosed());
			
			String sql = "Insert into user values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			pst.setString(1,login.getUsername());
			pst.setString(2,login.getPassword());
			
			
			
			
			rs = pst.executeUpdate();	
			
		    }
		    catch(Exception ex){
		    	ex.printStackTrace();
		    }
		    
		
		return 0;
	}

}