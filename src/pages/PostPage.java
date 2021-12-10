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
 * Servlet implementation class PostPage
 */
@WebServlet("/PostPage")
public class PostPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostService postService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPage() {
    	super();
    	postService = new PostServiceImpl(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DateFormat format = DateFormat.getDateInstance(DateFormat.LONG);
		String postId = request.getParameter("id");
		Post post = postService.getPostByID(Integer.parseInt(postId));
		request.setAttribute("post", post);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("PostPage.jsp").include(request, response);
		
		/*PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String head = "<head><title>Post</title><link rel='stylesheet' type='text/css' href='" + cssLocation + "'></head>";
	    out.println("<html/>");
	    out.println(head);
	    out.print(Header.GetHeader());
		out.println("<h1>"+post.getTitle()+"</h1>");
		out.println("<p>"+format.format(post.getCreated())+"</p>");
		out.println("<p>"+post.getDescription()+"</p>");
		if(user!=null&&user.getId()==post.getUserId()){
			out.print("<a href='/ProjectTest1/edit-post?id="+post.getId()+"'><button>편집 </button></a>");
			out.print("<form action='delete-post' method='post'><input name='id' value='"+post.getId()+"' hidden='true'/><button>삭제</button></form>");
		}
		out.print("</body></html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
