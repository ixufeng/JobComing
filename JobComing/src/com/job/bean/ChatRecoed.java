package com.job.bean;

import java.util.Date;

public class ChatRecoed {
	//聊天记录：聊天编号     用户编号（发送人） 用户编号(接收人) 内容   时间    状态
	private int chatRecordId;
	private int userSendId;
	private int userReciveId;
	private String chatContent;
	private Date time;
	private String status;
	public int getChatRecordId() {
		return chatRecordId;
	}
	public void setChatRecordId(int chatRecordId) {
		this.chatRecordId = chatRecordId;
	}
	public int getUserSendId() {
		return userSendId;
	}
	public void setUserSendId(int userSendId) {
		this.userSendId = userSendId;
	}
	public int getUserReciveId() {
		return userReciveId;
	}
	public void setUserReciveId(int userReciveId) {
		this.userReciveId = userReciveId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ChatRecoed() {
		super();
	}
	


}
