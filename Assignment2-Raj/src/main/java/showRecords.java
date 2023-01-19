import java.io.*;

import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;

public class showRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();        
              String no=request.getParameter("empno");                          

              try{

                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/as_2_raj","root","root");               
                     PreparedStatement ps=con.prepareStatement("select * from emp where empname = ?");
                     ps.setString(1,no);                   

                     out.print("<table width=90% border=1>");
                     out.print("<center><h1>Result:</h1></center>");
                     ResultSet rs=ps.executeQuery();                
                     /* Printing column names */
                     ResultSetMetaData rsmd=rs.getMetaData();
                     while(rs.next())
                        {
                    	 out.print("<tr>");
                    	 out.print("<td>"+rsmd.getColumnName(1)+"</td>");
                         out.print("<td>"+rs.getString(1)+"</td></tr>");
                         out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                         out.print("<td>"+rs.getString(2)+"</td></tr>");
                         out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
                         out.print("<td>"+rs.getString(3)+"</td></tr>");
                         out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
                         out.print("<td>"+rs.getString(4)+"</td></tr>");                  

                     }
                     out.print("</table>");

              }
              catch (Exception e2){
                    e2.printStackTrace();
                }
              finally{out.close();
                }
       }

 
}