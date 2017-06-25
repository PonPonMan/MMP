package com.core.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日期工具类
 * 
 * @author 傅文城 2017年4月28日 下午2:59:49
 */
public class DateTool {

	private static SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat shortFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 返回当前日期
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getCurrDateString() {
		Calendar calendar = Calendar.getInstance();
		return shortFormat.format(calendar.getTime());
	}

	/**
	 * 返回当前时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrTimeString() {
		Calendar calendar = Calendar.getInstance();
		return longFormat.format(calendar.getTime());
	}

	/**
	 * 返回当前时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Timestamp getCurrTimestamp() {
		return Timestamp.valueOf(getCurrTimeString());
	}
}
