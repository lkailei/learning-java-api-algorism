package com.kaysanshi.question;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_DateAndTime {
	/*
	 * 时间的信息格式化：再将它以年月日格式输出：
	 */
	public static void main(String[] args) {
		Date time=new Date();
		System.out.println(time);
		String s="yyy年mm月dd日";
		SimpleDateFormat m=new SimpleDateFormat(s);
		System.out.println(m.format(time));

	}

}
