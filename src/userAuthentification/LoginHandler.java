package userAuthentification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.User;
import repository.UserRepository;

public class LoginHandler {
	
	private UserRepository repository;
	
	public LoginHandler () {
		repository = UserRepository.getInstance();
	}
	
	public boolean doLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = repository.userLogin(username, password);
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
        }
        
        if (user!=null) {
            request.getSession().setAttribute("user", user);
            System.out.println("Principal is: " + request.getSession().getAttribute("user"));
        } else {
            return false;
        }
		
		return true;
		
	}

}
