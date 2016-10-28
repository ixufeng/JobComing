package com.job.dao;

import java.util.List;

import com.job.bean.AddressCity;

public interface AddressCityDao {
	//通过城市名称返回所属省份的编号
	public int getProvinceCode(String cityName);
	//通过城市名称返回所属城市的编号
	public int  getCityCodeBycityName(String cityName);
	//通过省份编号返回一个城市集合
	public List<AddressCity> getAddressCityListByPCode(int provinceCode);
	//通过城市编码 返回一个城市对象
	public AddressCity getAddressCityByCityCode(int cityCode);
	//通过城市名称 返回一个城市对象
	public AddressCity getAddressCityByCityName(String cityName);
}
