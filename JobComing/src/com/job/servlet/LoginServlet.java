package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.bean.User;
import com.job.daoImpl.UserDaoImpl;
import com.job.service.UserService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserService us=new UserService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//判断用户名密码是否正确 
		UserDaoImpl usd=new UserDaoImpl();
		if(us.istrue(username, password,usd)){
			//将用户对象存入Session
			User user=usd.getUser(username);
			session.setAttribute("user", user);
			request.getRequestDispatcher("").forward(request, response);;
		}else{
			request.setAttribute("error", "用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
