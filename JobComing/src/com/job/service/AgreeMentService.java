package com.job.service;

import com.job.bean.AgreeMent;
import com.job.bean.AgreeMentState;
import com.job.bean.User;
import com.job.dao.AgreeMentDao;
import com.job.daoImpl.AgreeMentDaoImpl;

public class AgreeMentService {
	private AgreeMentDao aDao = new AgreeMentDaoImpl();
	
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
	
	
}
