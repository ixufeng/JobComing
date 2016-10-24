package com.job.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.job.bean.JobKind;
import com.job.dao.JobKindDao;
import com.job.hibernate.CommonQuery;

public class JobKindDaoImpI implements JobKindDao {
	private CommonQuery query = new CommonQuery();
	@Override
	/**
	 * 插入一个工作种类
	 */
	public int add(String hql, Object[] params) {
	
		return query.update(hql, params);
	}

	@Override
	/**
	 * 删除一个工作种类
	 */
	public int delete(String hql, Object[] params) {
		
		return query.update(hql, params);
			
	}

	@Override
	/**
	 * 修改一个工作种类的信息
	 */
	public int update(String hql, Object[] params) {
	
		return query.update(hql, params);
	}
	/**
	 * 返回一个工作种类对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public JobKind getJobKind(String hql, Object[] params){
		JobKind jobKind=new JobKind();
		jobKind=(JobKind) query.getObj(hql, params);
		return jobKind;
	}
	
	/**
	 * 返回一个工作种类集合
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<JobKind>getJobKindList(String hql,Object[]params){
		List<JobKind>list=new ArrayList<JobKind>();
		list=(List<JobKind>) query.getObj(hql, params);
		return list;
	}
	/**
	 * 通过工作种类Id返回工作种类对象
	 * @param jobKindId
	 * @return
	 */
	public JobKind getJobKind(int jobKindId){
		String hql="from JobKind where jobKindId=?";
		Object[] params=new Object[]{jobKindId};
		return getJobKind(hql, params);
	}
	/**
	 * 通过工作种类名称返回工作种类对象
	 * @param jobKindName
	 * @return
	 */
	public JobKind getJobKind(String jobKindName){
		String hql="from JobKind where jobKindName=?";
		Object[] params=new Object[]{jobKindName};
		return getJobKind(hql, params);
	}
}
