package com.job.test;

import com.job.bean.User;
import com.job.daoImpl.UserDaoImpl;

public class Test {
	
	private UserDaoImpl userDao = new UserDaoImpl();

	@org.junit.Test
	public void test(){
		User user = new User();
		user.setUserName("匆匆那年YY");
		user.setPassword("123456");
		userDao.add(user);
	}
}
