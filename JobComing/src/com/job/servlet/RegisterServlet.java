package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.User;
import com.job.service.UserService;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("!!!!!!!!!注册业务逻辑!!!!!!!!!!");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password1");
		String email=request.getParameter("email");
		long phone=Long.parseLong(request.getParameter("phone"));
		String trueName=request.getParameter("realname");
	    String birth=request.getParameter("age");
		String sex=request.getParameter("sex");
		
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setTrueName(trueName);
		user.setBirthday(birth);
		user.setSex(sex);
		UserService us=new UserService();
		if(us.register(user)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "注册失败！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
