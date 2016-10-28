package com.job.bean;

import java.util.Date;

public class SocketMessage {

	private String userKey;
	private String	receivedUserKey;
	private String content;
	private Date date;
	
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getReceivedUserKey() {
		return receivedUserKey;
	}
	public void setReceivedUserKey(String receivedUserKey) {
		this.receivedUserKey = receivedUserKey;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
