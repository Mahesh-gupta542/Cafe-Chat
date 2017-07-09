package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import dao.DemoDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
@MultipartConfig
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("login");
		if (login.equalsIgnoreCase("0")){
			System.out.println("hello");
			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");  
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DemoDao daobj = new DemoDao();
		HttpSession session=request.getSession();
		try{
			  if (request.getParameter("create").equalsIgnoreCase("Create My Account")){
				HashMap<String, String> user = new HashMap<>();
				user.put("fname", request.getParameter("first_name"));
				user.put("lname", request.getParameter("last_name"));
				user.put("email", request.getParameter("email"));
				user.put("dob", request.getParameter("date_of_birth"));
				user.put("password", request.getParameter("password"));
				
				Part filePart = request.getPart("pic");
				int file_size=(int) filePart.getSize();
				user.put("file", filePart.getSubmittedFileName());
				FileInputStream inputStream = (FileInputStream) filePart.getInputStream();
				boolean saveDetails=daobj.saveUserDetail(user, inputStream, file_size);
				if(saveDetails==true){
					session.setAttribute("username", request.getParameter("first_name"));
					session.setAttribute("userId", request.getParameter("email"));
					PrintWriter out=response.getWriter();
					out.print("Welcome " + request.getParameter("first_name"));
					RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
					rd.include(request, response);
				}else
					response.getWriter().append("Failed Served at: ").append(request.getContextPath());

			  }
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}

}
