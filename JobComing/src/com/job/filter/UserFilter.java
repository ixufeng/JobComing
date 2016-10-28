package com.job.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
//@WebFilter("/*.do")
=======
//@WebFilter("*.do")
>>>>>>> 4ad151c57cec5dea24d2fc299e18e44656d5922f
public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/**
	 * 用户过滤器 没登录就返回原本网页  登录了就跳转相应界面
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			chain.doFilter(arg0, arg1);
		}else{
			String url=request.getRequestURI();
			request.getRequestDispatcher(url).forward(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
