package com.job.service;

import java.util.ArrayList;

import com.job.bean.JobShow;
import com.job.dao.JobPublishDao;
import com.job.dao.UserDao;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;

public class ShowJobService {
	
	private JobPublishDao jobDao = new JobPublishImpI();
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 有具体地址的显示
	 * @param pageIndex
	 * @param pageSize
	 * @param locationId
	 * @return
	 */
	public ArrayList<JobShow> getJobShow(int pageIndex,int pageSize,int locationId){		
		ArrayList<JobShow> list = new ArrayList<JobShow>();
		
		
		return list;
	}
	
	/**
	 * 没有地位的获取工作信息
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ArrayList<JobShow>getJobShow(int pageIndex,int pageSize){
		ArrayList<JobShow> list = new ArrayList<JobShow>();
		
		
		return null;
	}
	
	
	
	
	
}
