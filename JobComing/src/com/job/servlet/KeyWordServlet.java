package com.job.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.AddressCity;
import com.job.bean.JobKind;
import com.job.service.ShowJobService;

/**
 * Servlet implementation class KeyWordServlet
 */
@WebServlet("/KeyWordServlet")
public class KeyWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShowJobService jobService = new ShowJobService();

	
    public KeyWordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> keylist=new ArrayList<String>();
		System.out.println("--------------------");
		List<JobKind> list= jobService.getJobType();
		for(int i=0;i<list.size();i++){
			keylist.add(list.get(i).getJobKindName());
		}
		List<AddressCity> list2=jobService.getCity();
		for(int i=0;i<list2.size();i++){
			keylist.add(list2.get(i).getCityName());
		}
		List<String> implist=new ArrayList<String>();
		String searchName= request.getParameter("searchName");
		for(int i=0;i<keylist.size();i++){
			if(keylist.get(i).indexOf(searchName)!=-1&&searchName.trim()!=""){
				implist.add(keylist.get(i));
			}
		}
		response.setContentType("text/html,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(implist.toString());
		
	}

}
