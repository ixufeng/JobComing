package com.job.service;


import java.util.ArrayList;
import java.util.List;


import com.job.bean.AddressTown;
import com.job.bean.JobKind;
import com.job.bean.JobPublish;
import com.job.bean.JobShow;
import com.job.bean.User;
import com.job.daoImpl.AddressCityDaoImpI;
import com.job.daoImpl.AddressTownDaoImpI;
import com.job.daoImpl.JobKindDaoImpI;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;


public class DetailJobService {
	private JobShow jobShow=new JobShow();
	private JobKind jobKind=new JobKind();
	private JobPublish jobPublish=new JobPublish();
	private User user=new User();
	private UserDaoImpl uImpl=new UserDaoImpl();
	private JobKindDaoImpI jkImpI=new JobKindDaoImpI();
	private JobPublishImpI jpImpI=new JobPublishImpI();
	private AddressTownDaoImpI townDaoImpI=new AddressTownDaoImpI();
	private AddressCityDaoImpI cityDaoImpI=new AddressCityDaoImpI();
	private ShowJobService sJobService=new ShowJobService();
	private String location="";
	/**
	 * 通过发布工作id返回jobshow对象
	 * @param jobPublishId
	 * @return
	 */
	public JobShow getJSByJpId(int jobPublishId){
		jobPublish=jpImpI.getJobPublish(jobPublishId);
		jobKind=jkImpI.getJobKind(jobPublish.getJobKindId());
		user=uImpl.getUser(jobPublish.getUserId());
		
		AddressTown addressTown= townDaoImpI.geAddressTownByTownCode(jobPublish.getAddressNumber());
		if(addressTown!=null){
			location=addressTown.getTownName();
		}else{
			location=cityDaoImpI.getAddressCityByCityCode(jobPublish.getAddressNumber()).getCityName();
		}
		jobShow.setJobKind(jobKind);
		jobShow.setJobPublish(jobPublish);
		jobShow.setUser(user);
		jobShow.setLocation(location);
		return jobShow;
	}
	
	/**
	 * 返回今日推送集合
	 */
	public List<JobShow> getTodayWork(int addressNumber){
		List<JobShow>list=new ArrayList<JobShow>();
		list=sJobService.getTodayWork(addressNumber);
		return list;
	}
	/**
	 * 添加至浏览记录
	 * @param jobShow
	 * @return
	 */
	public void addWatchRecord(JobShow jobShow,List<JobShow> jList){
			jList.add(jobShow);
	}
}
