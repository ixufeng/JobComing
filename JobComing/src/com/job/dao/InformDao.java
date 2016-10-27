package com.job.dao;

import java.util.List;

import com.job.bean.Inform;

public interface InformDao extends QueryDao {
	// 根据消息编号更改消息记录状态
	public int update(int informId);
	 //根据用户id和返回一个已读或未读消息记录集合
	public List<Inform> getIListByReUserIdAndStatus(int informReciveId,int status);
	//根据一条消息对象插入消息表
	public int add(Inform inform);
}
