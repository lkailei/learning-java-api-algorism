package com.kaysanshi.question;

import java.util.Scanner;

//给定一个数字n，计算出从1+2+3+。。。+n的和 递归求和
public class Sum1{
	
	int test(int n){
		if(n==1){
			return 1;
		}else{
			return test(n-1)+n;
		}
	}
	public static void main(String[] args) {
		Sum1 sum1=new Sum1();
		System.out.println("请输入要计算的数");
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int s=sum1.test(m);
		System.out.println(s);
		
	}

}
