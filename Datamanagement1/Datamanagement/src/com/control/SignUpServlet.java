package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbservice.SignupDBservice;
import com.dto.SignUpBeanClass;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/sigin")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		String gender=request.getParameter("gen");
		String country=request.getParameter("cntry");
		String mobile=request.getParameter("umbno");
		String address=request.getParameter("addr");
		SignUpBeanClass su=new SignUpBeanClass();
		su.setName(name);
		su.setPass(pass);
		su.setGender(gender);
		su.setCountry(country);
		su.setMobile(mobile);
		su.setAddress(address);
		SignupDBservice sb=new SignupDBservice();
		boolean ba=sb.save(su);
		if(ba)
		{
			response.sendRedirect("Login.html");
		}else
		{
			out.println("Failed.....!");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
