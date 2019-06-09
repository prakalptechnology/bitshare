package org.vikash.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.vikash.bitshare.AbstractDao;
import org.vikash.dto.Users;

/**
 * Servlet implementation class SignUp
 */
@Path("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AbstractDao ab = new AbstractDao();
		//int userId=ab.getMaxUserId();
		Users user=new Users();
		
		//user.setUser_id(userId+1);
		user.setFirst_Name(request.getParameter("fname"));
		user.setLast_name(request.getParameter("lname"));
		user.setUsername(request.getParameter("uname"));
		try {
			user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setEmail_id(request.getParameter("emailId"));
		//user.setTN(request.getParameter(""));
		user.setCreation_time(new Date());
		user.setActive(true);
		
		if(request.getParameter("psw").equals(request.getParameter("cnfpsw")))
			ab.register(user,request.getParameter("psw"));
		response.getWriter().append("Registered");
		//doGet(request, response);
	}

}
