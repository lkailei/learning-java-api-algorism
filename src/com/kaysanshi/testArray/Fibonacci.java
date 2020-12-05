package com.kaysanshi.testArray;
/**
 * 斐波那契数列:
 * 递归调用；
 * @author kaysanshi
 *@date 2019年4月27日
 */
public class Fibonacci {

	public static int getnumber(int n){
		
		if (n==1) {
			return 0;
		}else if (n==2) {
			return 1;
		}else{
			return getnumber(n-1)+getnumber(n-2);
		}
		
	}
	
	public static void main(String[] args) {
		int res=Fibonacci.getnumber(20);
		System.out.println(res);
	}
}
