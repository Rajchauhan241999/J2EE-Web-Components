

import java.io.IOException;    
import java.io.PrintWriter;    
import java.sql.*;    
import javax.servlet.ServletException;    
import javax.servlet.annotation.WebServlet;    
import javax.servlet.http.HttpServlet;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;    
    
/**  
 * Servlet implementation class MovieServlet  
 */    
@WebServlet("/MovieServlet")    
public class MovieServlet extends HttpServlet {    
    private static final long serialVersionUID = 1L;    
           
    /**  
     * @see HttpServlet#HttpServlet()  
     */    
    public MovieServlet() {    
        super();    
        // TODO Auto-generated constructor stub    
    }    
    
    /**  
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)  
     */    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        // TODO Auto-generated method stub    
        response.getWriter().append("Served at: ").append(request.getContextPath());    
    }    
    
    /**  
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)  
     */    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
            
        PrintWriter pw;    
        response.setContentType("text/html");    
        pw=response.getWriter();    
            
            
        String name=request.getParameter("name");    
        String actor=request.getParameter("actor");    
        String actress=request.getParameter("actress");    
        String director=request.getParameter("director");    
        String rDate=request.getParameter("rDate");    
        String rPoint=request.getParameter("rPoint");    
        float rating=Float.parseFloat(rPoint);    
            
            
        try    
        {    
            Class.forName("com.mysql.jdbc.Driver");    
            String url="jdbc:mysql://localhost:3306/firstdb";    
            String user="root";    
            String password="root";    
                
            Connection con=DriverManager.getConnection(url, user, password);    
            String query="Insert into movie(name,actor,actress,director,releaseDate,ratingPoint) values (?,?,?,?,?,?);";    
            PreparedStatement pstmt=con.prepareStatement(query);    
            pstmt.setString(1, name);    
            pstmt.setString(2, actor);    
            pstmt.setString(3,actress);    
            pstmt.setString(4, director);    
            pstmt.setString(5, rDate);    
            pstmt.setFloat(6,rating);    
                
            int x=pstmt.executeUpdate();    
                
            if(x==1)    
            {    
            pw.println("Values Inserted Successfully");    
            }    
                
        }    
        catch(Exception e)    
        {    
                e.printStackTrace();    
        }    
            
            
        pw.close();    
    }    
    
} 