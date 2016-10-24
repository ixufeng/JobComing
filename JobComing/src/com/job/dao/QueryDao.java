package com.job.dao;

public interface QueryDao {

	public int add(String hql,Object[] params);
	public int delete(String hql,Object[] params);
	public int update(String hql,Object[] params);
	
	
}
