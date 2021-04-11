package com.kaysanshi.question;

import java.util.StringTokenizer;

public class Test_String_remove {
	//去除空格；用for循环的来实现
	public static void main(String[] args) {
		String s="java is very oop";
		System.out.println("Java中本有的去除方法1："+s.replaceAll(" ",""));
		StringTokenizer st=new StringTokenizer(s," ");//s是要去除空格的字符串，后一个是要去除的字符串：
		StringBuffer sb=new StringBuffer();
		@SuppressWarnings("unused")
		int i=1;
		while(st.hasMoreTokens()){
			i++;
			sb.append(st.nextToken());
		}
		System.out.println("Java中本有的去除方法2："+sb.toString());
		System.out.println("下面用for循环来实现3：");
		String s1="java is very oop";
		for(int j=0;j<s1.length();j++){
			if(s1.charAt(j)!=' '){
				System.out.print(s1.charAt(j));
			}

		}

	}

}
