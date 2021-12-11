package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Post;
import service.PostService;
import service.PostServiceImpl;

/**
 * Servlet implementation class EditPost
 */
@WebServlet("/EditPost")
public class EditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPost() {
		super();
		postService = new PostServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String postId = request.getParameter("id");
		Post post = postService.getPostByID(Integer.parseInt(postId));
		request.setAttribute("post", post);
		request.getRequestDispatcher("EditePost.jsp").include(request, response);

		/*
		 * PrintWriter out = response.getWriter(); String cssLocation = "css/main.css";
		 * String head =
		 * "<head><title>Edite post</title><link rel='stylesheet' type='text/css' href='"
		 * + cssLocation + "'></head>"; out.println("<html/>"); out.println(head);
		 * out.print(Header.GetHeader()); out.print("<form method='post'>");
		 * out.print("<label>Title:</label></br>");
		 * out.println("<input name='title' value='"+post.getTitle()
		 * +"' required='required'/></br>");
		 * out.print("<label>Description:</label></br>");
		 * out.println("<textarea name='description' required='required'>"+post.
		 * getDescription()+"</textarea></br>"); out.print("<button>save</button>");
		 * out.print("</form>"); out.print("</body></html>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostService postService = new PostServiceImpl();
		Post post = new Post();
		post.setTitle(request.getParameter("title"));
		post.setDescription(request.getParameter("description"));
		post.setId(Integer.parseInt(request.getParameter("id")));
		postService.updatePost(post);
		response.sendRedirect("/ProjectTest1/post?id=" + post.getId());
		doGet(request, response);
	}

}
