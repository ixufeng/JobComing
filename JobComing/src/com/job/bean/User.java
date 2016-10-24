package com.job.bean;

public class User {
	//编号,用户名,真实姓名,年龄,密码,性别,手机号码,邮箱,头像,用户积分（信誉度）,二维码
	private int userId;
	private String userName;
	private String trueName;
	private String password;
	private int age;
	private int sex;
	private long phone;
	private String email;
	private String headPicture;
	private int score;
	private String identifyCode;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getIdentifyCode() {
		return identifyCode;
	}
	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	public User() {
		super();
	}
	

}
