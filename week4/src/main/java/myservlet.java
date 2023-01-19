

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class myservlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
try{
doProcess(request,response);
}catch(SQLException e){
e.printStackTrace();
}
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
try{
doProcess(request,response);
}catch(SQLException e){
e.printStackTrace();
}
}
private void doProcess(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException , SQLException{
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
PrintWriter out = response.getWriter();
try{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyInfo","root","root");
stmt = conn.createStatement();
rs = stmt.executeQuery("select * from Phonebook");

out.print("<html>");
out.print("<head>");
out.print("<title>Hello Connect Database</title>");
out.print("</head>");
out.print("<name>");
out.print("<h1>Name from database</h1>");
out.print("<br/>");

System.out.println("Get value from table userinformation.");
while(rs.next()){
out.println("<tr>");
out.print("Name : " + rs.getString("name"));
out.print("\t\t\t");

out.print("Sex : " + rs.getString("sex"));

out.print("Address : " + rs.getString("address"));

out.print("</tr><br/>");
}

out.print("</body>");
out.print("</html>");
// out.flush();
}catch(Exception e){
e.printStackTrace();
}finally{
if(stmt != null){
stmt.close();
}
if(conn != null){
conn.close();
}
}
}
}