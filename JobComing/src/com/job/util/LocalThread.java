package com.job.util;

import javax.servlet.http.HttpSession;

/**
 * 存放当前线程内变量
 * @author xufeng
 *
 */
public class LocalThread {
	
	public static ThreadLocal<HttpSession> threadLocal = new ThreadLocal<HttpSession>(); 

}
