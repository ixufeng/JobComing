package com.job.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.job.bean.AddressCity;
import com.job.bean.JobPublish;
import com.job.bean.JobShow;
import com.job.dao.AddressCityDao;
import com.job.dao.UserDao;
import com.job.daoImpl.AddressCityDaoImpI;
import com.job.daoImpl.AddressTownDaoImpI;
import com.job.daoImpl.JobKindDaoImpI;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;

/**
 * 提供搜索的功能
 * @author xufeng
 *
 */  
public class SearchService {
	private JobPublishImpI jImpI=new JobPublishImpI();
	private UserDao userDao = new UserDaoImpl();
	private JobKindDaoImpI jobKindDao = new JobKindDaoImpI();
	private AddressTownDaoImpI townDaoImpl = new AddressTownDaoImpI();
	private AddressCityDao cityDaoImpl = new AddressCityDaoImpI();
	/**
	 * 通过兼职种类查询工作
	 * @param jobKindId
	 * @param pageIndex
	 * @param pageSize
	 * @param addressNumber
	 * @return
	 */
	public List<JobShow> getJobByKindId(int jobKindId,int pageIndex,int pageSize,int addressNumber){
		List<JobShow>list=new ArrayList<JobShow>();
		List<JobPublish> list2 =new ArrayList<JobPublish>();
		int beginIndex = pageSize*(pageIndex-1);
		list2=jImpI.getJPByJobKindPage(beginIndex, pageSize, addressNumber, jobKindId);
		for(JobPublish job:list2){
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
	 * 根据城市名字和兼职种类查询工作
	 * @param jobKindId
	 * @param pageIndex
	 * @param pageSize
	 * @param cityName
	 * @return
	 */
	public List<JobShow> getJobByCityName(int jobKindId, int pageIndex, int pageSize, String cityName) {
		List<JobShow> list = new ArrayList<JobShow>();
		List<JobPublish> list2 = new ArrayList<JobPublish>();
		int beginIndex = pageSize * (pageIndex - 1);
		if (cityDaoImpl.getAddressCityByCityName(cityName) != null){
			int addressNumber = cityDaoImpl.getAddressCityByCityName(cityName).getCityCode();
			if (addressNumber == 0&&townDaoImpl.geAddressTownByTownName(cityName)!=null) {
				addressNumber = townDaoImpl.geAddressTownByTownName(cityName).getTownCode();
			}
			list2 = jImpI.getJPByJobKindPage(beginIndex, pageSize, addressNumber, jobKindId);
			for (JobPublish job : list2) {
				JobShow jobShow = new JobShow();
				jobShow.setUser(userDao.getUser(job.getUserId()));
				jobShow.setJobKind(jobKindDao.getJobKind(job.getJobKindId()));
				AddressCity city = cityDaoImpl.getAddressCityByCityCode(addressNumber);
				jobShow.setLocation(city.getCityName());
				jobShow.setJobPublish(job);
				list.add(jobShow);
			}
		}
		return list;
	}
	/**
	 * 根据城市姓名查工作
	 * @param pageIndex
	 * @param pageSize
	 * @param cityName
	 * @return
	 */
	public List<JobShow> getJobByCityName( int pageIndex, int pageSize, String cityName){
		List<JobShow> list = new ArrayList<JobShow>();
		List<JobPublish> list2 = new ArrayList<JobPublish>();
		int beginIndex = pageSize * (pageIndex - 1);
		if (cityDaoImpl.getAddressCityByCityName(cityName) != null){
			int addressNumber = cityDaoImpl.getAddressCityByCityName(cityName).getCityCode();
			if (addressNumber == 0&&townDaoImpl.geAddressTownByTownName(cityName)!=null) {
				addressNumber = townDaoImpl.geAddressTownByTownName(cityName).getTownCode();
			}
			list2 = jImpI.getJPByPage(beginIndex, pageSize, addressNumber);
			for (JobPublish job : list2) {
				JobShow jobShow = new JobShow();
				jobShow.setUser(userDao.getUser(job.getUserId()));
				jobShow.setJobKind(jobKindDao.getJobKind(job.getJobKindId()));
				AddressCity city = cityDaoImpl.getAddressCityByCityCode(addressNumber);
				jobShow.setLocation(city.getCityName());
				jobShow.setJobPublish(job);
				list.add(jobShow);
			}
		}
		return list;
	}
}
