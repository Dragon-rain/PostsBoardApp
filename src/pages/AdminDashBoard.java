package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userAuthentification.AdminPageInterceptor;

/**
 * Servlet implementation class AdminDashBoard
 */
@WebServlet("/AdminDashBoard")
public class AdminDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminPageInterceptor adminPageInterceptor = new AdminPageInterceptor();
		adminPageInterceptor.withAdminAuthFilter(request, response);
		
	    request.getRequestDispatcher("AdminDashBoard.jsp").include(request, response);
	    
	    /*PrintWriter out = response.getWriter();
		String cssLocation = "css/main.css";
	    String head = "<head><title>게시판</title><link rel='stylesheet' type='text/css' href='" + cssLocation + "'></head>";
	    out.println("<html/>");
	    out.println(head);
	    out.print(Header.GetHeader());
		out.println("<h1>Admin</h1>");
		if(request.getSession().getAttribute("user")!=null) {
				out.print("<form action='logout' method='post'><button>Logout</button></form>");
		}
		out.print("<div>Admin page</div>");
		out.print("</body></html>");
		out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
