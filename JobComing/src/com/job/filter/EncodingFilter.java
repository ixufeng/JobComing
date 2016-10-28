package com.job.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
				
	}

	/**
	 * 字符过滤
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		String method = request.getMethod();
		//POST提交
		if(method.equals("POST")){
			request.setCharacterEncoding("UTF-8");
		}
		//GET提交
		else if(method.equals("GET")){
			Enumeration<String> names = request.getParameterNames();
			while(names.hasMoreElements()){
				String name = names.nextElement();
				String[] value = request.getParameterValues(name);
				//遍历 字符编码重构
				for(int i = 0;i < value.length;i++){
					value[i] = new String(value[i].getBytes("ISO-8859-1"), "UTF-8");
				}
			}
		}
		chain.doFilter(req, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
				
	}

}
