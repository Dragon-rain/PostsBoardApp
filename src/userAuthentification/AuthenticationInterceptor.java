package userAuthentification;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor {

	public void withAuthFilter(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			try {
				response.sendRedirect("/ProjectTest1/posts");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
