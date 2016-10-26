package com.job.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.User;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("!!!!!!!!!注册业务逻辑!!!!!!!!!!");
		String username=request.getParameter("username");
		String password=request.getParameter("password1");
		String email=request.getParameter("email");
		//long phone=request.getParameter("phone");
		String trueName=request.getParameter("realname");
		int year=new Date().getYear();
				
		
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		//user.setPhone(phone);
		user.setTrueName(trueName);
	}

}
