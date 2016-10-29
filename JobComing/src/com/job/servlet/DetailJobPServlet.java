package com.job.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
		LinkedList<JobShow> jList=null;
		HttpSession session=request.getSession();
		//添加至浏览记录
		if(session.getAttribute("jList")==null){
			jList=new LinkedList<JobShow>();
		}else{
			jList=(LinkedList<JobShow>) session.getAttribute("jList");
		
		}
		if(request.getParameter("jobPublishId")!=null){
			JobShow jobdetail = null;
			
			int jobPublishId=Integer.parseInt(request.getParameter("jobPublishId"));
			//详细工作详情
			jobdetail=dtservice.getJSByJpId(jobPublishId);
			request.setAttribute("jobdetail", jobdetail);
			JobShow jobShow = new JobShow(jobdetail.getJobPublish(), jobdetail.getJobKind(), jobdetail.getUser(), jobdetail.getLocation());
			jList.addFirst(jobShow);
			dtservice.retRecordList(jList);
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
