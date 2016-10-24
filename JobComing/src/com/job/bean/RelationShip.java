package com.job.bean;

public class RelationShip {
	//关注：关注编号  用户编号1(关注人)  用户编号2(被关注人)
	private int relationShipId;
	private int userIdA;
	private int userIdB;
	public int getRelationShipId() {
		return relationShipId;
	}
	public void setRelationShipId(int relationShipId) {
		this.relationShipId = relationShipId;
	}
	public int getUserIdA() {
		return userIdA;
	}
	public void setUserIdA(int userIdA) {
		this.userIdA = userIdA;
	}
	public int getUserIdB() {
		return userIdB;
	}
	public void setUserIdB(int userIdB) {
		this.userIdB = userIdB;
	}
	public RelationShip() {
		super();
	}
	
	

}
