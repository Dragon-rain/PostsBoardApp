package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13441214L;
	
	public LogoutServlet() {
		super();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("userId");
		resp.sendRedirect("/ProjectTest1");
	}


}
