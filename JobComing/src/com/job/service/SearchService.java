package com.job.service;

import java.util.ArrayList;
import java.util.List;



import com.job.bean.AddressCity;
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

/**
 * 提供搜索的功能
 * @author xufeng
 *
 */  
public class SearchService {
	private JobPublishImpI jImpI=new JobPublishImpI();
	private JobPublishDao jobDao = new JobPublishImpI();
	private UserDao userDao = new UserDaoImpl();
	private JobKindDaoImpI jobKindDao = new JobKindDaoImpI();
	private AddressTownDaoImpI townDaoImpl = new AddressTownDaoImpI();
	private AddressCityDao cityDaoImpl = new AddressCityDaoImpI();
	
	/**
	 * 根据输入的关键字实现模糊搜索,如果用户数据空或无效字符串，则返回null
	 * @param jobKind
	 * @return
	 */
	public ArrayList<JobPublish> getJobByKind(String jobKind){
		ArrayList<JobPublish> list = new ArrayList<JobPublish>();
		if(jobKind!=null&&(!"".equals(jobKind))){
			return null;
		}		
		return list;
	}
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
	 * 根据城市名字查询工作
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
}
