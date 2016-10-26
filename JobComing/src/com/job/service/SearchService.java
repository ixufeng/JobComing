package com.job.service;

import java.util.ArrayList;

import com.job.bean.JobPublish;
import com.job.dao.JobPublishDao;
import com.job.daoImpl.JobPublishImpI;

/**
 * 提供搜索的功能
 * @author xufeng
 *
 */  
public class SearchService {

	private JobPublishDao jobDao = new JobPublishImpI();
	
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

}
