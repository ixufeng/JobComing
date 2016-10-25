package com.job.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.job.util.LocalThread;

public class GetSession implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		LocalThread.threadLocal.set(arg0.getSession());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		LocalThread.threadLocal.set(null);
	}

}
