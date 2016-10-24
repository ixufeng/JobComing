package com.job.bean;

import java.util.Date;

public class JobPublish {
	//工作发布：	编号	用户编号	类别编号	发布时间	地址编号(省市区) 	详细地址	
	//工作开始时间	工作结束时间	描述
	private int jobPublishId;
	private int userId;
	private int jobKindId;
	private Date jobPublishTime;
	private String addressNumber;
	private String detailAddress;
	private Date workBeginTime;
	private Date workOverTime;
	private String workDescribe;
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
	public int getJobKindId() {
		return jobKindId;
	}
	public void setJobKindId(int jobKindId) {
		this.jobKindId = jobKindId;
	}
	public Date getJobPublishTime() {
		return jobPublishTime;
	}
	public void setJobPublishTime(Date jobPublishTime) {
		this.jobPublishTime = jobPublishTime;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public Date getWorkBeginTime() {
		return workBeginTime;
	}
	public void setWorkBeginTime(Date workBeginTime) {
		this.workBeginTime = workBeginTime;
	}
	public Date getWorkOverTime() {
		return workOverTime;
	}
	public void setWorkOverTime(Date workOverTime) {
		this.workOverTime = workOverTime;
	}
	public String getWorkDescribe() {
		return workDescribe;
	}
	public void setWorkDescribe(String workDescribe) {
		this.workDescribe = workDescribe;
	}
	public JobPublish() {
		super();
	}
	
	

}
