package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.User;
import com.job.service.EvaluateService;

/**
 * 评价的servlet
 * @author xufeng
 *
 */
@WebServlet("/evaluate.do")
public class EvaluateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EvaluateService evaluate = new EvaluateService();
    private String result = "error.jsp";
    public EvaluateServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = (User)request.getSession().getAttribute("user");
		String tempPublishId = request.getParameter("jobPublishId");
		String tempGrade = request.getParameter("grade");
		String content = request.getParameter("content");
		int jobPublishId = 0,grade = 0;
		try{
			jobPublishId = Integer.valueOf(tempPublishId);
			grade = Integer.valueOf(tempGrade);
		}catch(Exception e){
			//参数有误返回,返回页面
			request.setAttribute("error","参数有误！");
			this.result = "错误页面";
			
		}
		if(!"".equals(content)){
			//存入评价内容
			if(evaluate.evaluate(jobPublishId, u.getUserId(), content, grade)){
				//评价成功
				request.getRequestDispatcher("success.jsp").forward(request, response);
				result = "评价成功页面";
			}
		}else{
			this.result = "原页面";
		}
		
		request.getRequestDispatcher(this.result).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
