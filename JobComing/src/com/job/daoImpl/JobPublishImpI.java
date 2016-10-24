package com.job.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.job.bean.JobPublish;
import com.job.dao.JobPublishDao;
import com.job.hibernate.CommonQuery;

public class JobPublishImpI implements JobPublishDao{
    private CommonQuery query=new CommonQuery();
	@Override
	/**
	 * 插入一条兼职发布信息
	 */
	public int add(String hql, Object[] params) {
	
		return query.update(hql, params);
	}

	
	@Override
	/**
	 * 删除一条兼职发布信息
	 */
	public int delete(String hql, Object[] params) {
	
		return query.update(hql, params);
	}

	@Override
	/**
	 * 修改一条兼职发布信息
	 */
	public int update(String hql, Object[] params) {
	
		return query.update(hql, params);
	}
	/**
	 * 插入一条兼职发布信息
	 */
	public int add(JobPublish jp){
		Session session = query.getSession();
		Serializable se = session.save(jp);
		query.release(session);
		if(se!=null){
			return 1;
		}
		return 0;
		
	}
	/**
	 * 根据兼职信息编号删除一条兼职发布信息
	 */
	public int delete(int jobPublishId){
		String hql="delete from jobPublish where jobPublishId=?";
		Object[]params=new Object[]{jobPublishId};
		return delete(hql, params);
	}
	/**
	 * 根据兼职信息编号返回一条兼职信息
	 */
	@SuppressWarnings("unchecked")
	public JobPublish getJobPublish(int jobPublishId){
		JobPublish jp=new JobPublish();
		String hql="from jobPublish where jobPublishId=?";
		Object[]params=new Object[]{jobPublishId};
		jp=(JobPublish) query.getObj(hql, params);
		return jp;
	}
	/**
	 * 返回多条兼职信息
	 */
	@SuppressWarnings("unchecked")
	public List<JobPublish> getJobPublishList(String hql, Object[] params){
		List<JobPublish>list=new ArrayList<JobPublish>();
		list=(List<JobPublish>) query.getObj(hql, params);
		return list;
	}
	/**
	 * 根据工作种类返回多条兼职信息
	 */
	public List<JobPublish> getJobPublishList(int jobKindId){
		List<JobPublish>list=new ArrayList<>();
		String hql="from jobPublish where jobKindId=?";
		Object[]params=new Object[]{jobKindId};
		list=getJobPublishList(hql, params);
		return list;
	}
	/**
	 * 根据用户id返回多条兼职信息
	 */
	public List<JobPublish>getJPListByUserId(int userId){
		List<JobPublish>list=new ArrayList<>();
		String hql="from jobPublish where userId=?";
		Object[]params=new Object[]{userId};
		list=getJobPublishList(hql, params);
		return list;
	}
}
