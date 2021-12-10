package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Post;
import dto.User;
import service.PostService;
import service.PostServiceImpl;
import userAuthentification.AuthenticationInterceptor;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10, // 1 MB
	maxFileSize = 1024 * 1024 * 10,      // 10 MB
	maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthenticationInterceptor interceptor = new AuthenticationInterceptor();
		interceptor.withAuthFilter(request, response);
		request.getRequestDispatcher("addPost.html").include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostService postService = new PostServiceImpl(); 
		Post post = new Post();
		User user = (User)request.getSession().getAttribute("user");
		post.setTitle(request.getParameter("title")); 
		post.setDescription(request.getParameter("description"));
		post.setUserId(user.getId());
	    
		postService.addPost(post);
		response.sendRedirect("/ProjectTest1/posts");
		doGet(request, response);
	}

}
