package com.job.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.bean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 个人信息servlet
 */
@WebServlet("/PersonInforServlet.do")
public class PersonInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PersonInforServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		int age=0;
		//获取年龄
		if(user!=null){
			String birth=user.getBirthday();
			int birthday=Integer.parseInt(birth);
			String year=new SimpleDateFormat("yyyy").format(new Date());
			int currentyear=Integer.parseInt(year);
			age=currentyear-birthday;
		} 
		request.setAttribute("age", age);
		
		
		request.getRequestDispatcher("info1.jsp").forward(request, response);
	}

}
