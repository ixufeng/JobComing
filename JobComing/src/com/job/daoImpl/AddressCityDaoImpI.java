package com.job.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.job.bean.AddressCity;
import com.job.dao.AddressCityDao;
import com.job.hibernate.CommonQuery;

public class AddressCityDaoImpI implements AddressCityDao {
	private CommonQuery query=new CommonQuery();
	/**
	 * 通过城市名称返回所属省份的编号
	 * @param cityName
	 * @return
	 */
	public int getProvinceCode(String cityName){
		String hql="from AddressCity where cityName=? ";
		Object[]params=new Object[]{cityName};
		return (int) query.getObj(hql, params);
	}
	/**
	 * 通过省份编号返回一个城市集合
	 * @param provinceCode
	 * @return
	 */
	public List<AddressCity> getAddressCityListByPCode(int provinceCode){
		String hql="from AddressCity where provinceCode=?";
		Object[] params=new Object[]{provinceCode};
		List<AddressCity>list=new ArrayList<AddressCity>();
		List<Object> list2=query.selectForList(hql, params);
		for(int i=0;i<list2.size();i++){
			list.add((AddressCity)list.get(i));
		}
		return list;
	}
	/**
	 * 通过城市名称返回所属城市的编号
	 * @param cityName
	 * @return
	 */
	public int  getCityCodeBycityName(String cityName){
		String hql="from AddressCity where cityName=? ";
		Object[]params=new Object[]{cityName};
		return (int) query.getObj(hql, params);
	}
}
