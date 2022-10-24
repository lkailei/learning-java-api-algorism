package com.kaysanshi.question;

import java.util.Scanner;

/*
 * 问题：斐波那契数列：是由1.1，2,3,5,8,13,21,34，组成从第三个数是前两个元素的和
 * 创建一个方法接收一个值；显示这个值之前的斐波那契数列；
 */
public class BFibonacci {
	public void getFibonacci(int m){
		int a[]=new int[40];
		a[0]=1;
		a[1]=1;
		for(int i=0;i<a.length;i++){
//			先判断前面i<2情况下的数字；再把i赋初值为i后面的值；
			if(i<2){
				System.out.print(a[0]+" "+a[1]+" ");
				i=2;
			}
			a[i]=a[i-2]+a[i-1];
//			System.out.print(a[i]+" ");
			if(a[i]<=m){
//	进行比较输出；
				System.out.print(a[i]+" ");
			}
		}
	}

	public static void main(String[] args) {
		BFibonacci fn=new BFibonacci();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		fn.getFibonacci(n);
		scan.close();

	}

}
