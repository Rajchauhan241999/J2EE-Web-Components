package com.packages;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*; 

public class UserProcess extends HttpServlet{ 

// do post method
public void doPost(HttpServletRequest req, HttpServletResponse res) 
   throws ServletException,IOException 
   {  
	 res.setContentType("text/html;charset=UTF-8"); 
     //declared printwriter
     PrintWriter out=res.getWriter(); 

   
     // created an objects for each parameters 
     String firstname = req.getParameter("first name");
     String lastname = req.getParameter("last name");
     String email = req.getParameter("email");
     String zipcode = req.getParameter("zipcode");
     String username = req.getParameter("user name");
     String password = req.getParameter("password");
     //created an array for favourite music, which takes multiple input from checkbox parameters
     String fav [] = req.getParameterValues("music");
     // Declared condition parameter that gives yes or no selection from radio button 
     String cond = req.getParameter("yn");
    
    
     
     // check condition if user want to join mailing list then yes else no
     if(cond.equals("yes")) {
    	 // printing the output
    	 out.println("<html>");
    	 out.println("<head>");
         out.println("<h1> Thank you for joining our mailing list<h1>");
         out.println("<link href='style.css' type='text/css' rel='stylesheet' />");
         out.println("<head>");
        
         
         out.println("<body>");
         out.println("<td><h2> First Name:" + firstname + "</h2></td>");
         out.println("<td><h2> Last Name:" + lastname + "</h2></td>");
         out.println("<td><h2> Email:" + email + "</h2></td>");
         out.println("<td><h2> Zipcode:" + zipcode + "</h2></td>");
         out.println("<td><h2> User Name:" + username + "</h2></td>");
         out.println("<td><h2> Password:" + password + "</h2></td>");
         out.println("<td><h2> Favourite Music:</h2></td>");
         // for loop for favorite music
         for(int i=0; i<fav.length; i++)
         {
         out.print("<h2>" +fav[i]+ "</h2>"); 
         }
         out.println("<h2> Receive a special notfication:" + cond + "<h2>");
         
         
         out.println("</body>");
         out.println("</html>");
     }
     // the user not want to join in mailing list, shows this message
     else {
    	 out.println("<h2>Registered Sucessfully...</h2>");
     }
   
   }
}