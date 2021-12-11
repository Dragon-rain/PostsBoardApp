package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userAuthentification.LoginHandler;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private LoginHandler handler;
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		handler = new LoginHandler();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (handler.doLogin(req)) {
			resp.sendRedirect("/ProjectTest1/posts");
		} else {
			resp.sendRedirect("/ProjectTest1");
		}
	}

}
