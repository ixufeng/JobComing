package com.job.service;

import java.util.ArrayList;
import java.util.List;

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
		list = (ArrayList<Inform>) inform.getIListByReUserIdAndStatus(userId, 0);
		return list;	
	}
	/**
	 * 获取已读的通知
	 * @param userId
	 * @return
	 */
	public ArrayList<Inform> getOldInforms(int userId){
		ArrayList<Inform> list = new ArrayList<Inform>();
		list = (ArrayList<Inform>) inform.getIListByReUserIdAndStatus(userId, 1);
		return list;
	}
	/**
	 * 根据通知的id来标记为已经阅读
	 * @param arr
	 */
	public void checkInforms(List<Inform> list){
		
		for(Inform f:list){
			
			inform.update(f.getInformId());
		}
	}
}
