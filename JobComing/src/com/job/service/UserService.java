package com.job.service;



import com.job.bean.User;
import com.job.daoImpl.UserDaoImpl;


public class UserService {
	private UserDaoImpl userDaoImpl=new UserDaoImpl();
	/**
	 * 判断用户名密码是否正确  
	 * @param request
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean  istrue(String username,String pwd,UserDaoImpl usd){
		User user=usd.getUser(username);
		if(user!=null){
			if(user.getPassword().equals(pwd)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean register(User user){
		if(userDaoImpl.add(user)==1){
			return true;
		}else{
			return false;
		}
	}
}
