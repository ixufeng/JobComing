package com.job.bean;

import java.util.Date;

public class Evaluate {
	//评价：编号    发布编号  用户编号     评价等级    评论内容     评论时间
	private int evaluateId;
	private int jobPublishId;
	private int userId;
	private int grade;
	private String content;
	private Date evaluateTime;
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getEvaluateTime() {
		return evaluateTime;
	}
	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	public Evaluate() {
		super();
	}
	
}
