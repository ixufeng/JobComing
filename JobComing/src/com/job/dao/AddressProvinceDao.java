package com.job.dao;

import com.job.bean.AddressProvince;

public interface AddressProvinceDao {
	// 通过省级编码返回一个省级对象
	public AddressProvince getProvince(int provinceCode);
	// 通过省级名字返回一个省级对象
	public AddressProvince getProvince(String  provinName);
}
