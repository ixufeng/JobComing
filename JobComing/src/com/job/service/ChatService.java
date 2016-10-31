package com.job.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.job.bean.ChatRecoed;
import com.job.bean.ChatShow;
import com.job.bean.User;
import com.job.daoImpl.ChatRecordDaoImpI;
import com.job.daoImpl.UserDaoImpl;

import net.sf.json.JSONArray;


public class ChatService {
	private ChatRecordDaoImpI chatDao = new ChatRecordDaoImpI();
	private UserDaoImpl uDao = new UserDaoImpl();
	public boolean send(User u,String content,int receivedId){
		if(content.equals("")||content==null){
			return false;	
		}
		ChatRecoed  record = new   ChatRecoed();
		record.setChatContent(content);
		record.setTime(new Date());
		record.setStatus("0");
		record.setUserReciveId(receivedId);
		record.setUserSendId(u.getUserId());
		
		int res  = chatDao.add(record); 
		if(res>0){
			return true;
		}
		return false;		
	}
	
	/**
	 * 接受消息
	 * @return
	 */
	public String get(int userId){
		List<ChatShow> listshow = new ArrayList<ChatShow>();
		String hql =  "from ChatRecoed where userReciveId=?";
		Object[] params = new Object[]{userId};
		List<ChatRecoed> list = chatDao.getChatRecordList(hql, params);
		if(list!=null){
			
			String hql1 =  "delete from ChatRecoed where userReciveId=? ";
			chatDao.delete(hql1,params);
			for(ChatRecoed record:list){
				User u = uDao.getUser(record.getUserSendId());
				ChatShow show = new ChatShow(record,u);	
				listshow.add(show);
			}	
			
			return JSONArray.fromObject(listshow).toString();
			
		}else{
			return null;
		}
		
	}
}
