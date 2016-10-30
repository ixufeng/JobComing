package com.job.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.bean.JobShow;
import com.job.service.SearchService;
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
	private SearchService searchService=new SearchService();
	private int jobKindId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
       
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//添加兼职种类
		request.setAttribute("kindList", jobService.getJobType());
		if(session.getAttribute("jobList")==null){
			session.setAttribute("jobList", jobService.getJobShow(1, 20, 320500));
		}else{
			if(request.getParameter("jobKindId")!=null){
				//根据种类获取工作集合
				jobKindId=Integer.parseInt(request.getParameter("jobKindId"));
				session.setAttribute("jobKindId", jobKindId);
				if( session.getAttribute("cityName")!=null){
					String cityName=(String) session.getAttribute("cityName");
					session.setAttribute("jobList", searchService.getJobByCityName(jobKindId, 1, 5, cityName));
				}else{
					session.setAttribute("jobList", searchService.getJobByKindId(jobKindId, 1, 5, 320500));
				}
			}//else{
				//根据城市名称获得工作集合
			else if(request.getParameter("cityName")!=null){
				String cityName=request.getParameter("cityName");
				session.setAttribute("cityName", cityName);
				if(session.getAttribute("jobKindId")!=null){
					int jobKindId=(Integer)session.getAttribute("jobKindId");
					session.setAttribute("jobList", searchService.getJobByCityName(jobKindId, 1, 5, cityName));
				}else{
					session.setAttribute("jobList", searchService.getJobByCityName(1, 5, cityName));
				}
			}else{
				session.setAttribute("jobList", jobService.getJobShow(1, 20, 320500));
			}
		}

		request.setAttribute("hotList", jobService.getTodayWork(320500));
		if((List<JobShow>) session.getAttribute("jList")!=null){
			List<JobShow>list=(List<JobShow>) session.getAttribute("jList");
			request.setAttribute("recordList", list);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
