package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.service.ShowJobService;

/**
 * 跳转到主页
 * @author xufeng
 *
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowJobService jobService = new ShowJobService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("actoin");
		//String u = request.getParameter("user");
		//添加兼职种类
		request.setAttribute("kindList", jobService.getJobType());
		request.setAttribute("jobList", jobService.getJobShow(1, 20, 320500));
		
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
