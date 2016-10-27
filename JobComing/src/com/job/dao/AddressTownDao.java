package com.job.dao;

import java.util.List;

import com.job.bean.AddressTown;

public interface AddressTownDao {
	//通过所属城市编号返回区县集合
	public List<AddressTown> getTownListByCityCode(int cityCode);
	// 通过区县名称 返回一个区县对象
	public AddressTown geAddressTownByTownName(String townName );
	//通过区县编码 返回一个区县对象
	public AddressTown geAddressTownByTownCode(int townCode);
}
