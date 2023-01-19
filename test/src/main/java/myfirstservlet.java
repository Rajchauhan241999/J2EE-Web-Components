

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class secondclass
 */
@WebServlet("/myfirstservlet")
public class myfirstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myfirstservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		//String mycomputerid = request.getRemoteAddr();
//		//PrintWriter out = response.getWriter();
//		InetAddress ip = InetAddress.getLocalHost();
//		String mycomputerid = ip.getHostAddress();
//		String mycomputername = ip.getHostName();
//
//		out.println("my id:"+mycomputerid);
//		out.println("my name:"+mycomputername);
//		response.getWriter().append(ip.getHostAddress());
//		response.getWriter().println("Name:"+mycomputername);
//		 response.setContentType("text/html");
//	        response.getWriter().println("<h1>Hello Servlet!</h1>");
		
		String name = request.getParameter("t3");
		out.println("my name is"+name);
	}

	

}