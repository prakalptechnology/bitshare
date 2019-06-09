package org.vikash.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.vikash.bitshare.AbstractDao;
import org.vikash.dto.Users;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(); 
		String userName=request.getParameter("uname");
		userName=userName.trim();
		String password=request.getParameter("psw");
		password=password.trim();
		AbstractDao ab=new AbstractDao();
		
		try
		{
			if(ab.getPasswordByUserName(userName).trim().equals(password))
			{
				Users user=ab.getUserByUserName((String)userName);
				session.setAttribute("userName",userName);
				session.setAttribute("user",user);
				session.setAttribute("userfName",user.getFirst_Name());
				
				request.getRequestDispatcher("/mainFeed").forward(request, response);
			}
			else
			{
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
