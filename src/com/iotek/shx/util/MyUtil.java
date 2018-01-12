
package com.iotek.shx.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import sun.misc.BASE64Encoder;

public class MyUtil {
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
	public static String EncoderByutf8(String str) throws UnsupportedEncodingException{
		String newStr=new String(str.getBytes("iso-8859-1"),"utf-8");
		return newStr;
	}
	public static int totalDays(Date date){
		System.out.println(date);
		int count = 0;
		Calendar c=Calendar.getInstance();
		int year = date.getYear();
		int month=date.getMonth();
		int days=0;
		switch (month) {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:
			days=31;
			break;
		case 3:
		case 5:
		case 8:
		case 10:
			days=30;
			break;
		case 1:
			if((year+1900)%4==0 && year % 100 != 0 || year % 400 == 0){
			days=29;
			}else{
			days=28;	
			}
		break;
		default:
			break;
		}
		System.out.println(days);
		for (int i = 0; i < days; i++) {
			c.set(year+1900, month, i+1);
			Date newDate=c.getTime();
			System.out.println(newDate);
			if(c.get(Calendar.DAY_OF_WEEK)==7||c.get(Calendar.DAY_OF_WEEK)==1){
				System.out.println(newDate);
			}else{
				count++;
			}
		}
		return count;
	}
}