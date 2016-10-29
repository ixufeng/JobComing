package com.job.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.job.bean.User;
import com.job.daoImpl.UserDaoImpl;

public class Test {
	
	private UserDaoImpl userDao = new UserDaoImpl();

	@org.junit.Test
	public void test(){
		System.out.println(new SimpleDateFormat("yyyy").format(new Date()));
	}
}
