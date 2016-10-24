package com.job.daoImpl;

import com.job.dao.ChatRecordDao;
import com.job.hibernate.CommonQuery;

public class ChatRecordDaoImpI implements ChatRecordDao {
	private CommonQuery query=new CommonQuery();
	/**
	 * 添加一条聊天记录
	 */
	public int add(String hql, Object[] params) {
	
		return query.update(hql, params) ;
	}

	@Override
	/**
	 * 删除一条聊天记录
	 */
	public int delete(String hql, Object[] params) {
		
		return query.update(hql, params);
	}

	@Override
	/**
	 * 修改一条聊天记录
	 */
	public int update(String hql, Object[] params) {
		
		return query.update(hql, params);
	}

}
