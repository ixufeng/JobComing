package com.job.bean;

import java.util.Date;

public class ChatShow {

	private int chatRecordId;
	private int userSendId;
	private int userReciveId;
	private String chatContent;
	private Date time;
	
	private String status;
	private String userSendName;
	private String userSendImg;
	private String userSendEmail;
	
	public ChatShow(){
		
	}
	public ChatShow(ChatRecoed record,User u){
		this.chatRecordId = record.getChatRecordId();
		this.userSendId = record.getUserSendId();
		this.userReciveId = record.getUserReciveId();
		this.time = record.getTime();
		this.chatContent = record.getChatContent();
		this.status = record.getStatus();
		this.userSendName = u.getUserName();
		this.userSendImg = u.getHeadPicture();
		this.userSendEmail = u.getEmail();
	}
	
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
	public String getUserSendName() {
		return userSendName;
	}
	public void setUserSendName(String userSendName) {
		this.userSendName = userSendName;
	}
	public String getUserSendImg() {
		return userSendImg;
	}
	public void setUserSendImg(String userSendImg) {
		this.userSendImg = userSendImg;
	}
	public String getUserSendEmail() {
		return userSendEmail;
	}
	public void setUserSendEmail(String userSendEmail) {
		this.userSendEmail = userSendEmail;
	}
	
	
	
}
