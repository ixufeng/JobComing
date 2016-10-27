package com.job.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.job.bean.Inform;
import com.job.dao.InformDao;
import com.job.hibernate.CommonQuery;

public class InformDaoImpI implements InformDao {

	private CommonQuery query=new CommonQuery();

	/**
	 * 添加一条消息记录
	 */
	public int add(String hql, Object[] params) {
		
		return query.update(hql, params);
	}
	/**
	 * 根据一条消息对象插入消息表
	 */
	public int add(Inform inform){
		Session session = query.getSession();
		Serializable se = session.save(inform);
		query.release(session);
		if (se != null) {
			return 1;
		}
		return 0;
	}
	/**
	 * 删除一条消息记录
	 */
	public int delete(String hql, Object[] params) {
		
		return query.update(hql, params);
	}

	/**
	 * 更新一条消息记录
	 */
	public int update(String hql, Object[] params) {
		
		return query.update(hql, params);
	}
	/**
	 * 根据消息编号更改消息记录状态
	 */
	public int update(int informId){
		String hql="update Inform set informStatus=1 where informId=?";
		Object[]params=new Object[]{informId};
		return update(hql, params);
	}
	/**
	 * 根据用户id和返回一个未读或未读消息记录集合
	 */
	public List<Inform> getIListByReUserIdAndStatus(int informReciveId,int status){
		String hql="from Inform where informReciveId=? and infromStatus=？ ";
		Object[]params=new Object[]{informReciveId,status};
		List<Inform> list =new ArrayList<>();
		List<Object> list2 =query.selectForList(hql, params);
		list2 = query.selectForList(hql, params);
		for (int i = 0; i < list2.size(); i++) {
			list.add((Inform) list2.get(i));
		}
		return list;
	}
}
