package com.job.service;

import java.util.ArrayList;

import com.job.bean.Inform;
import com.job.daoImpl.InformDaoImpI;

/**
 * 通知服务
 * @author xufeng
 *
 */
public class ImformService {
	
	private InformDaoImpI inform = new InformDaoImpI();
	
	/**
	 * 获取未读的通知
	 * @param userId
	 * @return
	 */
	public ArrayList<Inform> getNewInforms(int userId){
		ArrayList<Inform> list = new ArrayList<Inform>();
		list = (ArrayList<Inform>) inform.getIListByReUserIdAndStatus(userId);
		return list;	
	}
	/**
	 * 获取已读的通知
	 * @param userId
	 * @return
	 */
	public ArrayList<Inform> getOldInforms(int userId){
		ArrayList<Inform> list = new ArrayList<Inform>();
		
		return list;
	}
}
