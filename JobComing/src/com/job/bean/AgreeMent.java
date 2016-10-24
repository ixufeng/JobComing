package com.job.bean;

import java.util.Date;

public class AgreeMent {
	//协议： 协议编号   发布编号   用户编号(收的人)
	//状态(投递成功 查看成功 达成协议/不适合 进度完成/” ”) 完成时间
	private int agreeMentId;
	private int jobPublishId;
	private int userId;
	private String status;
	private Date completeTime;
	public int getAgreeMentId() {
		return agreeMentId;
	}
	public void setAgreeMentId(int agreeMentId) {
		this.agreeMentId = agreeMentId;
	}
	public int getJobPublishId() {
		return jobPublishId;
	}
	public void setJobPublishId(int jobPublishId) {
		this.jobPublishId = jobPublishId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	public AgreeMent() {
		super();
	}
	
	
	
	


}
