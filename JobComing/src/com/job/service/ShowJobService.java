package com.job.service;

import java.util.ArrayList;
import java.util.List;


import com.job.bean.AddressCity;
import com.job.bean.AddressTown;
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
import com.job.util.TimeUtils;

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
	 * 最近浏览记录
	 */
	public void getHotJobType(){
		
		
	}
	
	
	/**
	 * 今日兼职推送
	 */
	public List<JobShow> getTodayWork(int addressNumber){
		ArrayList<JobPublish>list=new ArrayList<JobPublish>();
		List<JobShow>list2=new ArrayList<>();
		list=(ArrayList<JobPublish>) jobDao.getJBListByToday(TimeUtils.getTodayBeginDateTime(),addressNumber);
		for(int i=0;i<list.size();i++){
			//如果详细地址超过6位就缩写
			String address=list.get(i).getDetailAddress();
			if(address.length()>6){
				String modifyAddress=address.substring(0, 6);
				list.get(i).setDetailAddress(modifyAddress);
			}
			//通过工作种类id返回工作种类名称
			int jobKindId=list.get(i).getJobKindId();
			String jobKindName=jobKindDao.getJobKind(jobKindId).getJobKindName();
			//通过地点编号返回地点
			int adNumber=list.get(i).getAddressNumber();
			String location="";
			AddressTown addressTown=townDaoImpl.geAddressTownByTownCode(adNumber);
			if(addressTown!=null){
				location=addressTown.getTownName();
			}else{
				location=cityDaoImpl.getAddressCityByCityCode(adNumber).getCityName();
			}
			//将数据插入到jobshow集合里去
			JobShow jobShow=new JobShow();
			//工作种类
			JobKind jobKind=new JobKind();
			jobKind.setJobKindName(jobKindName);
			jobShow.setJobKind(jobKind);
			//发布的工作
			JobPublish jobPublish=new JobPublish();
			jobPublish.setDetailAddress(list.get(i).getDetailAddress());
			jobPublish.setJobPublishId(list.get(i).getJobPublishId());
			jobShow.setJobPublish(jobPublish);
			//地点
			jobShow.setLocation(location);
			list2.add(jobShow);
		}
		return list2;
	}

	
	
	
}
