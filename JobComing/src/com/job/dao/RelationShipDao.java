package com.job.dao;

import java.util.List;

import com.job.bean.RelationShip;

public interface RelationShipDao extends QueryDao {
	//根据一个关注对象添加一条关注记录
	public int add(RelationShip rs);
	//根据关注记录编号删除一条记录
	public int delete(int relationShipId);
	//返回一个关注记录集合
	public List<RelationShip>getRelationShipList(String hql,Object[]params);
}
