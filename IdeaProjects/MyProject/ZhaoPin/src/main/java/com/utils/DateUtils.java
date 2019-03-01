package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java 日期与字符串之间的转换
 * 资料:https://www.cnblogs.com/jxtx92/p/8005620.htmlhttps://www.cnblogs.com/jxtx92/p/8005620.html
 * 日期与字符串之间的转换:http://blog.csdn.net/jxq0816/article/details/51681186
 * @author liyunf
 *
 *
 */
public class DateUtils{

	/**
	 * 把字符串转换为日期型
	 * @param date
	 * @return
	 */
	public static Date getStringToDate(String date){
		Date datetime = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			datetime = sf.parse(date); //日期转换
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}

	/**
	 * 日期转换为字符串类型
	 * @param date
	 * @return
	 */
	public static String getDateToString(Date date){
		String datetime = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			datetime = sf.format(date); //日期转换
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}

}