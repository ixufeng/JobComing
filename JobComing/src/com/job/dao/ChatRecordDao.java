package com.job.dao;

import com.job.bean.ChatRecoed;

public interface ChatRecordDao extends QueryDao {
	//返回一个聊天记录对象
	public ChatRecoed getChatRecord(String hql, Object[] params);
	//根据聊天记录对象插入聊天记录表
	public int add(ChatRecoed cr);
	
}
