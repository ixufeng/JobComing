package com.job.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.bean.JobShow;
import com.job.service.DetailJobService;


/**
 * 发布的工作的详细界面
 */
@WebServlet("/DetailJobPServlet.do")
public class DetailJobPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailJobService  dtservice=new DetailJobService();
	private List<JobShow>jList;
	public DetailJobPServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("jobPublishId")!=null){
			HttpSession session=request.getSession();
			int jobPublishId=Integer.parseInt(request.getParameter("jobPublishId"));
			//详细工作详情
			JobShow jobdetail=dtservice.getJSByJpId(jobPublishId);
			request.setAttribute("jobdetail", jobdetail);
			//添加至浏览记录
			if(session.getAttribute("jList")==null){
				jList=new ArrayList<JobShow>();
			}else{
				jList=(List<JobShow>) session.getAttribute("jList");
			}
			dtservice.addWatchRecord(jobdetail,jList);
			session.setAttribute("jList", jList);
			//今日推送工作记录
			List<JobShow>list=dtservice.getTodayWork(320500);
			request.setAttribute("hotList1", list);
			request.getRequestDispatcher("JobInfo.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/MainPageServlet").forward(request, response);
		}
	}

}
