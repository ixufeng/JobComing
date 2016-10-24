package com.job.bean;

public class JobKind {
	//兼职类别:编号   名称   介绍
	private int jobKindId;
	private String jobKindName;
	private String jobKindIntroduce;
	public int getJobKindId() {
		return jobKindId;
	}
	public void setJobKindId(int jobKindId) {
		this.jobKindId = jobKindId;
	}
	public String getJobKindName() {
		return jobKindName;
	}
	public void setJobKindName(String jobKindName) {
		this.jobKindName = jobKindName;
	}
	public String getJobKindIntroduce() {
		return jobKindIntroduce;
	}
	public void setJobKindIntroduce(String jobKindIntroduce) {
		this.jobKindIntroduce = jobKindIntroduce;
	}
	public JobKind() {
		super();
	}
	

}
