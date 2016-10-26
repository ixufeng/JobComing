package com.job.dao;

import java.util.List;

import com.job.bean.AddressTown;

public interface AddressTownDao {
	//通过所属城市编号返回区县集合
	public List<AddressTown> getTownListByCityCode(int cityCode);
}
