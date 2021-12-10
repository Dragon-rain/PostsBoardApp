package userAuthentification;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import dto.UserRoles;

public class AdminPageInterceptor {
	
	public void withAdminAuthFilter(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("user");
		if(!admin.getRole().equals(UserRoles.ADMIN.name())) {
			try {
				response.sendRedirect("/ProjectTest1/posts");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
