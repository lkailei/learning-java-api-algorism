package com.question;

import java.util.Scanner;

/**
 *
 */
public class Division {
	
	public String division(int n,int m){
		if(n<1||m<1){
			System.out.println("���������");
		}else if (n==1||m==1){
			return 1+"";
		}else if(n<m){
			return this.division(n, n);
		}else if(n==m){
			return (1+"+"+this.division(n, n-1));
		}else{
			return (this.division(n, m-1)+"+"+this.division(n-m, m));
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("������Ҫ���ֵ�����");
		int n=new Scanner(System.in).nextInt();
		Division division=new Division();
		System.out.println(division.division(n, n));
	}
}
