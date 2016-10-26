package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.User;
import com.job.service.AgreeMentService;
import com.job.service.MailService;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MailService mail = new MailService();
	private AgreeMentService agreeMent = new AgreeMentService();
    public SendMailServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Object obj = request.getSession().getAttribute("user");
		User u = obj==null?null:(User)obj;
		if("pre".equalsIgnoreCase(action)){
			//预约兼职
			if(u!=null){
				//获取用户预约的招聘id
				String jobPublishId = request.getParameter("JobPublishId");
				int id;
				try{
					id = Integer.valueOf(jobPublishId);
				}catch(Exception e){
					response.getWriter().write("params fails");
					return ;
				}
				
				if(mail.sendHandleEmail(u, id,1)){
					//邮件发送成功
					response.getWriter().write("success");
					agreeMent.addAgreeMent(id, u);
				}
			}
		}else if("reply".equalsIgnoreCase(action)){
			//企业确定要人
			String userId = request.getParameter("userId");
			int id;
			try{
				id = Integer.valueOf(userId);
			}catch(Exception e){
				response.getWriter().write("params fails");
				return ;
			}
			if(u!=null){
				if(mail.sendHandleEmail(u, id,2)){
					//通知成功
					response.getWriter().write("success");
				}
				
			}
			
		}else if("confirm".equalsIgnoreCase(action)){
			//用户决定要去
			
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
