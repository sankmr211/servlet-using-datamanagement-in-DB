package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbservice.SignupDBservice;
import com.dto.SignUpBeanClass;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("lname");
		String upass=request.getParameter("lpass");
	    SignUpBeanClass s=new SignUpBeanClass();
	    s.setName(uname);
	    s.setPass(upass);
	    SignupDBservice db=new SignupDBservice();
	   boolean bn=db.loginDetails(s);
	   if(bn)
	   {
		   RequestDispatcher rd=request.getRequestDispatcher("welcome");
		   rd.forward(request, response);
	   }else
	   {
		   out.println("<font color='red' size='5'><b>Username or Password.......!</b></font>");
		   RequestDispatcher r=request.getRequestDispatcher("Login.html");
		   r.include(request, response);
	   }
	}     

}
