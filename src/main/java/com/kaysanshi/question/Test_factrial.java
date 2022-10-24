package com.kaysanshi.question;

import java.util.Scanner;

/**
 * 计算阶乘
 * 计算阶乘1+2！+3！+4!+....
 */
public class Test_factrial {
	public static void main(String[] args) {
		System.out.println("请输入阶乘");
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		scan.close();
		int rid=1;
		int sum=0;
			for( int j=1;j<=x;j++){
				rid*=j;
				sum+=rid;
			}	
		System.out.println(sum);
		//������while������
		int i=1;
		int sum1=0;
		int rid1=1;
		while(i<=10){
			rid1*=i;
			sum1+=rid1;	i++;
		}
		
		System.out.println(sum1);
	}
}
