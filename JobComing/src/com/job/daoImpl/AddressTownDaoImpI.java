package com.job.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.job.bean.AddressTown;
import com.job.dao.AddressTownDao;
import com.job.hibernate.CommonQuery;

public class AddressTownDaoImpI implements AddressTownDao {
	private CommonQuery query = new CommonQuery();

	/**
	 * 通过所属城市编号返回区县集合
	 * 
	 * @param cityCode
	 */
	public List<AddressTown> getTownListByCityCode(int cityCode) {
		String hql = "from AddressTown where cityCode=?";
		Object[] params = new Object[] { cityCode };
		List<AddressTown> list = new ArrayList<AddressTown>();
		List<Object> list2 = query.selectForList(hql, params);
		for (int i = 0; i < list2.size(); i++) {
			list.add((AddressTown) list.get(i));
		}
		return list;
	}

	/**
	 * 返回一条协议记录
	 */
	public AddressTown getAddressTown(String hql, Object[] params) {
		Object obj = query.getObj(hql, params);
		return obj == null ? null : (AddressTown) obj;
	}

	/**
	 * 通过区县名称 返回一个区县对象
	 * 
	 * @param townName
	 * @return
	 */
	public AddressTown geAddressTownByTownName(String townName) {
		String hql = "from AddressTown where townName=?";
		Object[] params = new Object[] { townName };
		return getAddressTown(hql, params);
	}
}
