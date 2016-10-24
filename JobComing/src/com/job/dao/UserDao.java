package com.job.dao;

import com.job.bean.User;

public interface UserDao extends QueryDao{
	
	public User getUser(String userName);
}
