package com.job.dao;

import com.job.bean.JobKind;

public interface JobKindDao extends QueryDao {
	// 根据一个工作种类对象插入工作种类表
	public int add(JobKind jk);
	//通过工作种类Id返回工作种类对象
	public JobKind getJobKind(int jobKindId);
	//通过工作种类名称返回工作种类对象
	public JobKind getJobKind(String jobKindName);
	// 返回一个工作种类对象
	public JobKind getJobKind(String hql, Object[] params);
	
	
}
