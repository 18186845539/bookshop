package org.ccunix.javaweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static String getParseDate(Date date,String pattern) {
		String str="";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		str = sdf.format(date);
		return str;
	}
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		
		//2018-09-11 16:55:58
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = sdf.format(date);
		System.out.println(str);
	}
}
