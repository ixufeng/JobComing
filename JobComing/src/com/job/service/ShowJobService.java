package com.job.service;

import java.util.ArrayList;
import java.util.List;

import com.job.bean.AddressCity;
import com.job.bean.JobKind;
import com.job.bean.JobPublish;
import com.job.bean.JobShow;
import com.job.dao.AddressCityDao;
import com.job.dao.JobPublishDao;
import com.job.dao.UserDao;
import com.job.daoImpl.AddressCityDaoImpI;
import com.job.daoImpl.AddressTownDaoImpI;
import com.job.daoImpl.JobKindDaoImpI;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;

public class ShowJobService {
	
	private JobPublishDao jobDao = new JobPublishImpI();
	private UserDao userDao = new UserDaoImpl();
	private JobKindDaoImpI jobKindDao = new JobKindDaoImpI();
	private AddressTownDaoImpI townDaoImpl = new AddressTownDaoImpI();
	private AddressCityDao cityDaoImpl = new AddressCityDaoImpI();
	/**
	 * 有具体地址的显示
	 * @param pageIndex
	 * @param pageSize
	 * @param locationId
	 * @return
	 */
	public ArrayList<JobShow> getJobShow(int pageIndex,int pageSize,int addressNumber){		
		ArrayList<JobShow> list = new ArrayList<JobShow>();
		int beginIndex = pageSize*(pageIndex-1);
		
		List<JobPublish> tempList = jobDao.getJPByPage(beginIndex, pageSize, addressNumber);
		
		for(JobPublish job:tempList){
			JobShow jobShow = new JobShow();		
			jobShow.setUser(userDao.getUser(job.getUserId()));
			jobShow.setJobKind(jobKindDao.getJobKind(job.getJobKindId()));
			AddressCity city = cityDaoImpl.getAddressCityByCityCode(addressNumber);
			jobShow.setLocation(city.getCityName());	
			jobShow.setJobPublish(job);	
			list.add(jobShow);
		}
		
		return list;
	}
	
	/**
	 * 默认的兼职形式,取十个
	 */
	public ArrayList<JobKind> getJobType(){
		ArrayList<JobKind> list = new ArrayList<JobKind>();
		list =  (ArrayList<JobKind>) jobKindDao.getJobKindList("from JobKind ", null);
		return list;
	}
	/**
	 * 获取热门的兼职形式
	 */
	public void getHotJobType(){
		
	}
	
	
	/**
	 * 今日兼职推送
	 */
	public void getTodayWork(){
		
		
	}
	
	
	
	
	
}
