package com.job.service;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import com.job.bean.SocketMessage;
import com.job.bean.User;
import com.job.util.LocalThread;

import net.sf.json.JSONObject;

/**
 * 处理websocket的消息
 * @author xufeng
 *
 */
public class SocketMessageHandle {

	public static void   handleMessage(Session session ,String message){
		System.out.println(message);
		SocketMessage mes = parseMesage(message);
		HttpSession hs = LocalThread.threadLocal.get();
		User u = (User) hs.getAttribute("user");
		if(mes==null||hs==null||u==null) return;

		System.out.println("1");
		for(JobWebSocket socket:JobWebSocket.webSocketSet){
			
				if(socket.getUserKey().equals(mes.getReceivedUserKey())){
					mes.setUserKey(u.getUserName());
					socket.sendMessage(parseMessageToJson(mes));
				}else{
					
					System.out.println("对方不在线");
				}
		}
		
	}
	
	
	/**
	 * 字符串转对象
	 * @param message
	 * @return
	 */
	public static SocketMessage parseMesage(String message){	
		try{			
			JSONObject obj = JSONObject.fromObject(message);
			return (SocketMessage) JSONObject.toBean(obj, SocketMessage.class);
		}catch(Exception e){
			return null;
		}
	
	}
	public static String parseMessageToJson(Object obj){
		
		return JSONObject.fromObject(obj).toString();
	}
	
}
