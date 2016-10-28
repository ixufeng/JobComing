package com.job.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 搜游兼职
 * @author xufeng
 *
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchServlet() {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("city".equals(action)){
			//按城市搜索
			request.getParameter("cityName");
			
		}else if("town".equals(action)){
			request.getParameter("townName");
		}else if("time".equals(action)){
			request.getParameter("time");
		}else if("province".equals(action)){
			request.getParameter("province");
		}else{
			//综合搜索
			request.getParameter("searchKey");
			 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
