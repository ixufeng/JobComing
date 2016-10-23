package com.job.dao;

import java.util.List;

public interface QueryDao {

	public int add(String hql,Object[] params);
	public int delete(String hql,Object[] params);
	public int update(String hql,Object[] params);
	public Object selectForSingle(String hql,Object[] params);
	public List<Object>selectForMulti(String hql,Object[] params);	
	
}
