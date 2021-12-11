package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import userAuthentification.AuthenticationInterceptor;

@WebServlet("/ChatPage")
public class ChatPage extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AuthenticationInterceptor interceptor;
	
	public ChatPage() {
		super();
		interceptor = new AuthenticationInterceptor();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		interceptor.withAuthFilter(request, response);
		request.getRequestDispatcher("chat.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
}
