package com.job.service;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @author xufeng
 *
 */
@ServerEndpoint("/websocket")
public class JobWebSocket {

	private static CopyOnWriteArraySet<JobWebSocket> webSocketSet = new CopyOnWriteArraySet<JobWebSocket>();
	
	private Session session;
	private String userKey;  //标志用户的id
	

	/**
	 * 建立连接时调用
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session){
		
			
		 this.session = session;
         webSocketSet.add(this);     //加入set中      
        
	}
	
	/**
	 * 链接关闭时调用
	 */
	@OnClose
	public void onClose(){
		
		webSocketSet.remove(this);
		
	}
	/**
	 * 发生错误时调用
	 */
	@OnError
	public void OnError(Session session,Throwable error){
		System.out.println("发生错误");
	}
	
	@OnMessage
	public void onMessage(String message,Session session){
		
		System.out.println("来自客户端的消息：" + message);
		 
		
	}
	
	/**
	 * 发送消息
	 * @param mes
	 */
	public void sendMessage(String mes){
		
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
	
}
