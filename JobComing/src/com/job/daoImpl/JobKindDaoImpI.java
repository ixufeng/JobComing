package com.job.daoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import com.job.bean.JobKind;
import com.job.bean.User;
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
	/**
	 * 根据一个工作种类对象插入工作种类表
	 * @param jk
	 * @return
	 */
	public int add(JobKind jk){
		Session session = query.getSession();
		Serializable se = session.save(jk);
		query.release(session);
		if(se!=null){
			return 1;
		}
		return 0;
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
		Object obj = query.getObj(hql, params);
		return obj==null?null:(JobKind)obj;
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
		List<Object>list2=new ArrayList<Object>();
		list2=query.selectForList(hql, params);
		for(int i=0;i<list2.size();i++){
			list.add((JobKind)list2.get(i));
		}
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
