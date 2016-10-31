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

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpTemp = request.getParameter("cp");
		int cp=1;
		if(cpTemp!=null){
			request.setAttribute("cp", 1);
			try{
				cp = Integer.valueOf(cpTemp);
				
			}catch(Exception e){
				cp = 1;
			}
		}
		request.setAttribute("cp", cp);
		
		
		HttpSession session=request.getSession();
		//添加兼职种类
		request.setAttribute("kindList", jobService.getJobType());
		if(session.getAttribute("jobList")==null){
			session.setAttribute("jobList", jobService.getJobShow(1, 20, 320500));
		}
		else{
			if(request.getParameter("mjobKindId")!=null){
				//根据种类获取工作集合
				jobKindId=Integer.parseInt(request.getParameter("mjobKindId"));
				session.setAttribute("mjobKindId", jobKindId);
				if( session.getAttribute("mcityName")!=null){
					String cityName=(String) session.getAttribute("mcityName");
					session.setAttribute("jobList", searchService.getJobByCityName(jobKindId, cp, 5, cityName));
				}else{
					session.setAttribute("jobList", searchService.getJobByKindId(jobKindId, cp, 5, 320500));
				}
			}//根据城市名称获得工作集合
			else if(request.getParameter("mcityName")!=null){
				String cityName=request.getParameter("mcityName");
				session.setAttribute("mcityName", cityName);
				if(session.getAttribute("mjobKindId")!=null){
					int jobKindId=(Integer)session.getAttribute("mjobKindId");
					session.setAttribute("jobList", searchService.getJobByCityName(jobKindId, cp, 5, cityName));
				}else{
					session.setAttribute("jobList", searchService.getJobByCityName(cp, 5, cityName));
				}
			}else{
				session.setAttribute("jobList", jobService.getJobShow(1, 20, 320500));
				session.setAttribute("jobList", jobService.getJobShow(cp, 20, 320500));
				
				List<JobShow> list = (List<JobShow>) session.getAttribute("jobList");
				System.out.println(list.size());
			}
		}
		session.setAttribute("hotList", jobService.getTodayWork(320500));
		if((List<JobShow>) session.getAttribute("jList")!=null){
			List<JobShow>list=(List<JobShow>) session.getAttribute("jList");
			request.setAttribute("recordList", list);
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
