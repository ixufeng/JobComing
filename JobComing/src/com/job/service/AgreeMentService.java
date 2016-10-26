package com.job.service;

import com.job.bean.AgreeMent;
import com.job.bean.AgreeMentState;
import com.job.bean.User;
import com.job.daoImpl.AgreeMentDaoImpl;

public class AgreeMentService {
	private AgreeMentDaoImpl aDao = new AgreeMentDaoImpl();
	
	
	/**
	 * 有人预约就会产生一个协议
	 */
	public void  addAgreeMent(int jobPublishId,User u){
		if(u!=null){
			
			AgreeMent ment = new AgreeMent();
			ment.setStatus(AgreeMentState.State_pre);
			ment.setJobPublishId(jobPublishId);
			ment.setUserId(u.getUserId());
			aDao.add(ment);
		}
	}
	
	/**
	 * 跟新协议状态
	 * @param jobPublishId
	 * @param state
	 */
	public boolean updateAgreeMentDao(int jobPublishId,String state){
		
		AgreeMent agreeMent = aDao.getAgreeMentByJobPublishId(jobPublishId);
		
		if(agreeMent!=null){
			
			int size = aDao.update(state, agreeMent.getAgreeMentId());
			
			if(size>0){				
				return true;
			}			
		}	
		return false;
	}
	
}
