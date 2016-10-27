package com.job.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.Inform;
import com.job.bean.User;
import com.job.service.ImformService;

/**
 * 查看通知的servlet
 * @author xufeng
 *
 */
@WebServlet("/InformServlet.do")
public class InformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImformService inform = new ImformService();
    public InformServlet() {
        super();     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("view".equalsIgnoreCase(action)){
			//获取所有未读通知
			User u = (User) request.getSession().getAttribute("user");
			ArrayList<Inform> list = inform.getNewInforms(u.getUserId());
			request.setAttribute("formList", list);
			//标记为已读
			inform.checkInforms(list);
			//跳转
			request.getRequestDispatcher("页面").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
