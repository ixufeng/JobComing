package com.job.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.job.bean.AgreeMent;
import com.job.dao.AgreeMentDao;
import com.job.hibernate.CommonQuery;


public class AgreeMentDaoImpl implements AgreeMentDao {
	private CommonQuery query=new CommonQuery();
	@Override
	/**
	 * 插入一条协议记录
	 */
	public int add(String hql, Object[] params) {
		
		return query.update(hql, params);
	}
	/**
	 * 根据一个协议对象插入协议记录表
	 */
	public int add(AgreeMent am){
		Session session = query.getSession();
		Serializable se = session.save(am);
		query.release(session);
		if(se!=null){
			return 1;
		}
		return 0;
	}
	@Override
	/**
	 * 删除一条协议记录
	 */
	public int delete(String hql, Object[] params) {
		return query.update(hql, params);
	}
	/**
	 * 根据协议编号删除协议记录
	 */
	public int Delete(int agreeMentId){
		String hql="delete from AgreeMent where agreeMentId=?";
		Object[]params=new Object[]{agreeMentId};
		return delete(hql, params);
	}
	@Override
	/**
	 * 更新一条协议记录
	 */
	public int update(String hql, Object[] params) {
		
		return query.update(hql, params);
	}
	/**
	 * 根据协议编号更新协议状态
	 */
	public int update(String status,int agreeMnetId){
		String hql="update AgreeMent set status=? where agreeMentId=?";
		Object[]params=new Object[]{status,agreeMnetId};
		return update(hql, params);
	}
	/**
	 * 返回一条协议记录
	 */
	public AgreeMent getAgreeMent(String hql, Object[] params) {
		Object obj = query.getObj(hql, params);
		return obj==null?null:(AgreeMent)obj;
	}
	/**
	 * 根据用户id返回协议记录集合
	 */
	public List<AgreeMent> getAgreeMentListByUserId(int userId){
		String hql="from AgreeMent where userId=?";
		Object[]params=new Object[]{userId};
		List<AgreeMent>list=new ArrayList<AgreeMent>();
		List<Object>list2=new ArrayList<Object>();
		list2=query.selectForList(hql, params);
		for(int i=0;i<list2.size();i++){
			list.add((AgreeMent)list2.get(i));
		}
		return list;
	}
}
