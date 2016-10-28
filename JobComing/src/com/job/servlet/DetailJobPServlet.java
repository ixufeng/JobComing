package com.job.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 发布的工作的详细界面
 */
@WebServlet("/DetailJobPServlet.do")
public class DetailJobPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailJobPServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getAttribute("jobPublishId")!=null){
			int jobPublishId=(Integer)request.getAttribute("jobPublishId");
			request.setAttribute("jobPublishId", jobPublishId);
			request.getRequestDispatcher("JobInfo.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("MainPageServlet").forward(request, response);
		}
	}

}
