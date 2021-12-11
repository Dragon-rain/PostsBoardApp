package pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Post;
import service.PostService;
import service.PostServiceImpl;

/**
 * Servlet implementation class PostsBoard
 */
@WebServlet("/PostsBoard")
public class PostsBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostsBoard() {
		super();
		service = new PostServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Post> postsList = service.getAllPosts();
		// DateFormat format = DateFormat.getDateInstance(DateFormat.LONG);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("postsList", postsList);

		request.getRequestDispatcher("PostsBoard.jsp").include(request, response);
		/*
		 * PrintWriter out = response.getWriter(); String cssLocation = "css/main.css";
		 * String head =
		 * "<head><title>게시판</title><link rel='stylesheet' type='text/css' href='" +
		 * cssLocation + "'></head>"; out.println("<html/>"); out.println(head);
		 * out.print(Header.GetHeader()); out.println("<h1>게시판</h1>");
		 * if(user!=null&&user.getRole().equals(UserRoles.ADMIN.name())){
		 * out.print("<a href='/ProjectTest1/administrator-page'>admin dash board</a>");
		 * }
		 * out.print("<a href='/ProjectTest1/add-post'><button>Add post</button></a>");
		 * if(user!=null) { out.
		 * print("<form action='logout' method='post'><button>Logout</button></form>");
		 * } out.println("<table>"); if(postsList.size() != 0) { postsList.forEach(post
		 * -> { out.println("<tr>");
		 * out.println("<th><a href='/ProjectTest1/post?id="+post.getId()+"'>"+post.
		 * getTitle()+"</a></th>");
		 * out.println("<th>"+format.format(post.getCreated())+"</th>");
		 * out.println("</tr>"); }); } else {
		 * out.println("<div>no any posts found</div>"); } out.println("</table>");
		 * out.print("</body></html>"); out.close();
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
