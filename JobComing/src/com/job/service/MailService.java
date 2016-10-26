package com.job.service;

import java.util.List;

import com.job.bean.JobPublish;
import com.job.bean.User;
import com.job.dao.JobPublishDao;
import com.job.dao.UserDao;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;
import com.xufeng.factory.MailFactory;
import com.xufeng.factory.MailServer;

public class MailService {

	private MailFactory factory = new MailFactory("mail.xml");
	private  JobPublishDao jbDao = new JobPublishImpI();
	private UserDao uDao = new UserDaoImpl();
	/**
	 * 发送一个邮件
	 * @param address 邮件地址
	 * @param title 邮件标题
	 * @param message 邮件内容
	 */
	public void sendAEmail(String address,String title,String message){
		MailServer server = this.factory.getMailServer();
		
		if(server!=null){
			server.sendMail(address, title, message);
		}
		
		
	}
	

	/**
	 * 群发相同的内容
	 * @param list 用户集合
	 * @param title 相同的标题
	 * @param message 相同的内容
	 */
	public void sendEmails(List<User> list,String title,String message){
		
		MailServer server = this.factory.getMailServer();

		for(User u:list){
			server.sendMail(u.getEmail(), title, message);
		}
	}
	/**
	 * 发送一个预约邮件
	 * @param user
	 * @param jobPublishId
	 * @return
	 */
	public boolean sendPreEmail(User user,int jobPublishId){
		
		JobPublish job = jbDao.getJobPublish(jobPublishId);
		if(job!=null&&user!=null){
			User u = uDao.getUser(job.getUserId());
			if(u!=null){
				//内容待补充
				sendAEmail(u.getEmail(),"title","content");
				
				return true;
			}
			
		}

		return false;
	}
	
		
}
