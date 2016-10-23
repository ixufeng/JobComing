package com.job.hibernate;

import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * 获取数据库的基本配置,并获取session
 * @author xufeng
 *
 */
public class MySqlSessionFactory {

	
	private static org.hibernate.SessionFactory sessionFactory;
	
	static{
		//获取配置文件
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build(); 		
		sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
		
	}
	
	public static Session getSession(){	

		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	public static void releaseResource(Session session){
		
		if(session!=null){
			if(session.isOpen()){
				//提交事务
				session.getTransaction().commit();
				session.close();
				session=null;
			}
			
		}							
	}
	
}
