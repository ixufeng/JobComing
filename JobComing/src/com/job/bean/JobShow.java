package com.job.bean;

public class JobShow {

	private JobPublish jobPublish;
	private JobKind jobKind;
	private User user;
	private String location;
	
	public JobShow() {
		super();
	}
	
	
	
	public JobShow(JobPublish jobPublish, JobKind jobKind, User user, String location) {
		super();
		this.jobPublish = jobPublish;
		this.jobKind = jobKind;
		this.user = user;
		this.location = location;
	}



	public JobPublish getJobPublish() {
		return jobPublish;
	}
	public void setJobPublish(JobPublish jobPublish) {
		this.jobPublish = jobPublish;
	}
	public JobKind getJobKind() {
		return jobKind;
	}
	public void setJobKind(JobKind jobKind) {
		this.jobKind = jobKind;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
