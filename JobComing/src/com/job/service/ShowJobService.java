package com.job.service;

import java.util.ArrayList;
import java.util.List;

import com.job.bean.JobPublish;
import com.job.bean.JobShow;
import com.job.dao.JobPublishDao;
import com.job.dao.UserDao;
import com.job.daoImpl.JobKindDaoImpI;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;

public class ShowJobService {
	
	private JobPublishDao jobDao = new JobPublishImpI();
	private UserDao userDao = new UserDaoImpl();
	private JobKindDaoImpI jobKindDao = new JobKindDaoImpI();
	
	/**
	 * 有具体地址的显示
	 * @param pageIndex
	 * @param pageSize
	 * @param locationId
	 * @return
	 */
	public ArrayList<JobShow> getJobShow(int pageIndex,int pageSize,int addressNumber){		
		ArrayList<JobShow> list = new ArrayList<JobShow>();
		int beginIndex = pageSize*(pageIndex-1)+1;
		
		List<JobPublish> tempList = jobDao.getJPByPage(beginIndex, pageSize, addressNumber);
		
		for(JobPublish job:tempList){
			JobShow jobShow = new JobShow();
			
			jobShow.setUser(userDao.getUser(job.getUserId()));
			jobShow.setJobKind(jobKindDao.getJobKind(job.getJobKindId()));
			//jobShow.setLocation();
			
			jobShow.setJobPublish(job);	
		}
		
		return list;
	}
	
	
	
	
	
	
}
