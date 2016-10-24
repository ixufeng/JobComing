package com.job.dao;

import java.util.List;

import com.job.bean.Evaluate;

public interface EvaluateDao extends QueryDao {
	// 得到一个评论对象
	public Evaluate getEvaluate(String hql, Object[] params);
	//根据评论对象插入一条评论信息
	public int add(Evaluate eval);
	//根据用户id返回一个评价集合
	public List<Evaluate> getEvaluateListByUserId(int userid);
	//根据评论编号删除评论
	public int delete(int evaluateid);
}
