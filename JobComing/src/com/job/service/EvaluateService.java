package com.job.service;

import java.util.Date;

import org.junit.Test;

import com.job.bean.Evaluate;
import com.job.bean.JobPublish;
import com.job.bean.User;
import com.job.daoImpl.EvaluateDaoImpI;
import com.job.daoImpl.JobPublishImpI;
import com.job.daoImpl.UserDaoImpl;

/**
 * 评价处理
 * @author xufeng
 *
 */
public class EvaluateService {
	
	private EvaluateDaoImpI evaluate = new EvaluateDaoImpI();
	private UserDaoImpl uDao =  new UserDaoImpl();
	private JobPublishImpI jobDao = new JobPublishImpI();
	/**
	 * 评价处理
	 * @param JobPublishId
	 * @param userId
	 * @param content
	 * @param grade
	 * @return
	 */
	public boolean evaluate(int jobPublishId,int userId,String content,int grade){
		
		Evaluate e = new Evaluate();
		
		e.setContent(content);
		e.setEvaluateTime(new Date());
		e.setGrade(grade);
		e.setJobPublishId(jobPublishId);
		e.setUserId(userId);
		
		int res = this.evaluate.add(e);
		if(res >0){
			//插入记录成功,影响发布人的信誉
			JobPublish job = jobDao.getJobPublish(jobPublishId);
			int tempUserId = job.getUserId();
			User u = uDao.getUser(tempUserId);
			if(u!=null){				
				int currentGra = u.getScore();
				int tempGrade = grade - currentGra;
				if(tempGrade>0){
					int effect = tempGrade/10;
					
					uDao.updateScore(effect, tempUserId);
				}else{
					int effect = tempGrade/5;
					uDao.updateScore(effect, tempUserId);
					
				}
				return true;
			}		
		}		
		return false;
	}
	@Test
	public void test(){
		User u = new User();
		u.setUserName("nihoao");
		u.setPassword("12345678");
		uDao.add(u);
	}

}
