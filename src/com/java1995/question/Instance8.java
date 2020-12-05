package com.java1995.question;

import java.util.Scanner;

public class Instance8 {
	//	????????????????????????
//	首先在控制台输入一个字符串
//	然后在控制台输入子串
//	计算子串出现的次数
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("请输入一个字符串");
		String s=scan.nextLine();
		System.out.println("请输入一个子串：");
		String s1=scan.nextLine();
		int count=0;
		if(s.equals(null)||s1.equals(null)){
			System.out.println("没有可匹配的子串");
		}else{
			for(int i=0;i<s.length();i++){
				System.out.println(s.substring(i));
				System.out.println("形式二"+s.substring(0, i+1));
				if(s1.equals(s.substring(i))||s1.equals(s.substring( 0, i+1))){
					count++;
				}
			}
		}
		System.out.println(count);
	}
}