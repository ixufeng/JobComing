package com.job.daoImpl;

import java.util.List;

import com.job.dao.UserDao;
import com.job.hibernate.CommonQuery;

public class UserDaoImpl implements UserDao {

	private CommonQuery query = new CommonQuery();
	
	@Override
	public int add(String hql, Object[] params) {
		
		return query.update(hql, params);
		
	}

	@Override
	public int delete(String hql, Object[] params) {
		return query.update(hql, params);
		
	}

	@Override
	public int update(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object selectForSingle(String hql, Object[] params) {
		
		Object obj = query.getObj(hql, params);
				
		return null;
	}

	@Override
	public List<Object> selectForMulti(String hql, Object[] params) {
		
		return null;
	}


}
