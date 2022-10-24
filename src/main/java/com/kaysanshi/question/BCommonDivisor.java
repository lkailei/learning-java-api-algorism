package com.kaysanshi.question;

import java.util.Scanner;
//最大公约数，想想一下短除法
public class BCommonDivisor {
	
	public int test(int a,int b){
		int d=1;
		for(int i=2;i<=a&&i<=b;i++){
			while(a%i==0&&b%i==0){
				d=d*i;
				a=a/i;
				b=b/i;
			}
		}
		return d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCommonDivisor i9=new BCommonDivisor();
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入两个数子");
		int a=scan.nextInt();
		int b=scan.nextInt();
		scan.close();
		System.out.println(i9.test(a, b));

	}

}
