package com.job.dao;

import java.util.List;

import com.job.bean.AgreeMent;

public interface AgreeMentDao extends QueryDao {
	//根据一个协议对象插入协议记录表
	public int add(AgreeMent am);
	//根据协议编号删除协议记录
	public int Delete(int agreeMentId);
	//根据协议编号更新协议状态
	public int update(String status,int agreeMnetId);
	//根据用户id返回协议记录集合
	public List<AgreeMent> getAgreeMentListByUserId(int userId);
	//返回一条协议记录
	public AgreeMent getAgreeMent(String hql, Object[] params);

}
