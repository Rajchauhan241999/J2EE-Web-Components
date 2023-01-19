
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logindao loginDao;
    
    public void init() {
    	this.loginDao = new Logindao();
    }
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		
		Loginmodel login = new Loginmodel();
		
		login.setUsername(username);
		login.setPassword(password);
		try {
			loginDao.registerUser(login);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
		
		response.sendRedirect("success.jsp");
		
	}

}
