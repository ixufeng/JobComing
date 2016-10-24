package com.job.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.job.bean.Evaluate;
import com.job.dao.EvaluateDao;
import com.job.hibernate.CommonQuery;

public class EvaluateDaoImpI implements EvaluateDao {

	CommonQuery query=new CommonQuery();
	/**
	 * 插入一条评论信息
	 */
	public int add(String hql, Object[] params) {
	
		return query.update(hql, params);
	}
	/**
	 * 插入一条评论信息
	 * @param chr
	 * @return
	 */
	public int add(Evaluate eval){
		Session session = query.getSession();
		Serializable se = session.save(eval);
		query.release(session);
		if(se!=null){
			return 1;
		}
		return 0;
		
	}
	@Override
	/**
	 * 删除一条评论信息
	 */
	public int delete(String hql, Object[] params) {
		
		return query.update(hql, params);
	}

	@Override
	/**
	 * 更新一条评论信息
	 */
	public int update(String hql, Object[] params) {
		
		return query.update(hql, params);
	}
	/**
	 * 根据用户id返回一个评价集合
	 */
	@SuppressWarnings("unchecked")
	public List<Evaluate> getEvaluateByUserId(int userid){
		List<Evaluate>list=new ArrayList<>();
		String hql="from Evaluate where userId=?";
		Object[]params=new Object[]{userid};
		list=(List<Evaluate>) query.getObj(hql, params);
		return list;
	}
	/**
	 * 根据评论编号删除评论
	 */
	public int delete(int evaluateid){
		String hql="delete from Evaluate where evaluate=?";
		Object[]params=new Object[]{evaluateid};
		return delete(hql, params);
	}
}
