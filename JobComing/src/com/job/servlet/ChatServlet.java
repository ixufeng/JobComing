package com.job.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.job.bean.User;
import com.job.service.ChatService;


@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChatService chat = new  ChatService();
 
    public ChatServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Object temp =request.getSession().getAttribute("user");
		User u = null;
		if(temp!=null){
			u=(User) temp;		
		}else{
			
			return;
		}
		if("send".equals(action)){
			System.out.println("send");
			String content = request.getParameter("content");
			int receivedUserKey;
			try{
				 receivedUserKey = Integer.valueOf(request.getParameter("receivedUserKey"));	
			}catch(Exception e){
				response.getWriter().write("failure");
				return;
			}
						
			if(chat.send(u, content, receivedUserKey)){
				response.getWriter().write("{success}");
			}else{
				response.getWriter().write("{failure}");
			}
			
			
			
		}else if("get".equals(action)){
			
			String res = chat.get(u.getUserId());
			if(res!=null){
				response.getWriter().write(res);
			}else{
				response.getWriter().write("[]");
			}
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
