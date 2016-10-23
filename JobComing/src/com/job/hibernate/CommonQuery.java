package com.job.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


/**
 * hql的增删查改
 * @author xufeng
 */
public class CommonQuery {

	/**
	 * 根据条件来查询结果集
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> selectForList(String hql,Object[] params){
		Session session =MySqlSessionFactory.getSession();
		Query query = getQuery(hql,params,session);
		List<Object> tempList = query.list();		
		MySqlSessionFactory.releaseResource(session);
		return tempList;
	}
	
	/**
	 * 执行更新语句,增删改
	 * @param hql
	 * @param params
	 * @return
	 */
	public int update(String hql,Object[] params){
		
		Session session =MySqlSessionFactory.getSession();		
		Query query = getQuery(hql,params,session);				
		int num = query.executeUpdate();
		MySqlSessionFactory.releaseResource(session);
		return num;
	}
	
	/**
	 * 查询一个对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Object getObj(String hql,Object[] params){
		
		Session session =MySqlSessionFactory.getSession();	
		Query query = getQuery(hql,params,session);		
		Object obj =  query.uniqueResult();
		MySqlSessionFactory.releaseResource(session);
		return obj;
	}
	
	
	/**
	 * 获取查询对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Query getQuery(String hql,Object[] params,Session session){

		
		Query query = session.createQuery(hql);			
		if(params!=null){
			for(int i =0;i<params.length;i++){				
				query.setParameter(i, params[i]);
			}
		}
		
		return query;
	}
	
	/**
	 * 获取事物
	 * @return
	 */
	public Session getSession(){		
		return MySqlSessionFactory.getSession();
	}
	
	/**
	 * 释放资源并提交事务
	 * @param session
	 */
	public void release(Session session){
		MySqlSessionFactory.releaseResource(session);
	}

}
