package com.job.bean;

import java.util.Date;

public class Inform {
	private int informId;
	private int informSendId;
	private int informReciveId;
	private String informContent;
	private int informStatue;
	private Date informTime;
	public int getInformId() {
		return informId;
	}
	public void setInformId(int informId) {
		this.informId = informId;
	}
	public int getInformSendId() {
		return informSendId;
	}
	public void setInformSendId(int informSendId) {
		this.informSendId = informSendId;
	}
	public int getInformReciveId() {
		return informReciveId;
	}
	public void setInformReciveId(int informReciveId) {
		this.informReciveId = informReciveId;
	}
	public String getInformContent() {
		return informContent;
	}
	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}
	public int getInformStatue() {
		return informStatue;
	}
	public void setInformStatue(int informStatue) {
		this.informStatue = informStatue;
	}
	public Date getInformTime() {
		return informTime;
	}
	public void setInformTime(Date informTime) {
		this.informTime = informTime;
	}
	public Inform() {
		super();
	}
	
}
