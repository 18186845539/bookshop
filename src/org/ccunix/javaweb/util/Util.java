package org.ccunix.javaweb.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Util {

	public static String getDateFormatString(Date date,String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(date);
	}
	/*
	 * 通过UUID获得随机数
	 * 0  代表前面补充0
	 * 12 代表长度为12
	 * d 代表参数为整数型
	 * 
	 */
	public static String getOrderNoByUUID() {
		int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV<0) {
        	hashCodeV = -hashCodeV;
        }
		return "1"+String.format("%012d",hashCodeV);
	}
	/*
	 * 
	 * 通过日期获得随机数
	 * 
	 */
	public static String getOrderNoByDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		String result="";
		for(int i=0;i<3;i++) {
			result+=random.nextInt(10);
		}
		return sdf.format(new Date())+result;
	}
	public static void main(String[] args) {
		Date date = new Date();//当前时间
		
		/*System.out.println(date);
		
		//2018-09-10 14:38:10
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String str = sf.format(date);
		System.out.println(str);*/
		
		/*String pattern = "yyyy年MM月dd日  HH:mm:ss";
		String str1 = getDateFormatString(date,pattern);
		System.out.println(str1);*/
		
		
		/*for(int i=0;i<100;i++) {
			System.out.println(getOrderNoByDate());
		}*/
		for(int i=0;i<100;i++) {
			System.out.println(System.currentTimeMillis());
		}
		
		
	}
}
