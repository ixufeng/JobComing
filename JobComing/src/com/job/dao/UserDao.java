package com.job.dao;

import com.job.bean.User;

public interface UserDao extends QueryDao{

	//插入一个用户
	public int add(User user);
	//修改用户头像
	public int update(String headPicture,int userId);
	//返回一个用户对象
	public User getUser(String hql, Object[] params);
	//通过用户Id返回一个用户对象
	public User getUser(int userId);
	//通过用户姓名返回一个用户对象
	public User getUser(String userName);
	//根据手机号返回一个用户对象
	public User getUserByPhone(long phone);
	//根据邮箱返回一个用户对象
	public User getUserByEmail(String email);
}
