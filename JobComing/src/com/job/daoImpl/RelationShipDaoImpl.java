package com.job.daoImpl;

import com.job.dao.RelationShipDao;
import com.job.hibernate.CommonQuery;


public class RelationShipDaoImpl implements RelationShipDao {
	private CommonQuery query=new CommonQuery();
	/**
	 * 添加一条关注记录
	 */
	@Override
	public int add(String hql, Object[] params) {
	
		return query.update(hql, params);
	}

	@Override
	/**
	 * 
	 */
	public int delete(String hql, Object[] params) {
		
		return 0;
	}

	@Override
	public int update(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
