package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.User;

/**
 * 发布工作或者删除工作
 * @author xufeng
 *
 */
@WebServlet("/ReleaseJob.do")
public class ReleaseJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReleaseJob() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		User u = (User) request.getSession().getAttribute("user");
		if("release".equalsIgnoreCase(action)){
			//发布工作
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
