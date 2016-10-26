package com.job.daoImpl;

import com.job.bean.AddressProvince;
import com.job.dao.AddressProvinceDao;
import com.job.hibernate.CommonQuery;

public class AddressProviceDaoImpl implements AddressProvinceDao  {
	private CommonQuery query=new CommonQuery();
	/**
	 * 返回一个省级对象
	 */
	public AddressProvince getProvince(String hql, Object[] params) {
		Object obj = query.getObj(hql, params);
		return obj == null ? null : (AddressProvince) obj;
	}

	/**
	 * 通过省级编码返回一个省级对象
	 * @param cityCode
	 * @return
	 */
	public AddressProvince getProvince(int provinceCode){
		String hql="from AddressProvince where provinceCode=?";
		Object[] params = new Object[] { provinceCode };
		return getProvince(hql, params);
		
	}
	/**
	 * 通过省级名字返回一个省级对象
	 */
	public AddressProvince getProvince(String  provinName){
		String hql="from AddressProvince where provinceCode=?";
		Object[] params = new Object[] {provinName};
		return getProvince(hql, params);
		
	}
}
