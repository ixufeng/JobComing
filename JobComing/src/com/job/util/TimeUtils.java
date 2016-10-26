package com.job.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtils {


	/**
	 * 获取当前精确的时间戳,精确到秒
	 */
	public static long getCTimeStamp(){
		
		 return System.currentTimeMillis()/1000;  		 
	}
	
	/**
	 * 时间戳转换为具体时间格式
	 * @param seconds
	 * @param format
	 * @return
	 */
	 public static String timeStampDate(long seconds,String format) {  
         
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        
        return sdf.format(new Date(seconds*1000));  
	 } 
	
	 /**
	  * 根据String的时间来返回龙型
	  * @return
	  */
	 public static long timeStampLong(String time,String format){
		 
		try {
			Date dd = new SimpleDateFormat(format).parse(time);
			
			return dd.getTime()/1000;
		} catch (ParseException e) {
			
			return -1;
		}
	 }
	 
	 public static long getTodayBeginTime(){
		 
		 Calendar cal = Calendar.getInstance();
		
		 Date date= cal.getTime();
		 
		 String time = timeStampDate(date.getTime()/1000,"yyyy-MM-dd");
		 
		 long time1 = TimeUtils.timeStampLong(time, "yyyy-MM-dd");
		 return time1;
	 }
	 
	 public static long getTadayEndTime(){
		 
		 return getTodayBeginTime() + 24*3600;
	 }
	 
	
	
	
}
