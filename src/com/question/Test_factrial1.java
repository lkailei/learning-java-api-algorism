package com.question;

import java.util.Scanner;

public class Test_factrial1 {
//1+1/2!+1/3!+1/4!+...
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入阶乘");
		int x=scan.nextInt();
		double rid=1;
		double sum=0;
		scan.close();
		for(int i=1;i<=x;i++){
			rid*=i;
			sum+=(1/rid);
		}
		System.out.println(sum);
		int i=1;
		double rid1=1;
		double sum1=0;
		while(i<20){
			rid1*=i;
			sum1+=(1/rid1);
			i++;
		}
		System.out.println(sum1);
	}

}
