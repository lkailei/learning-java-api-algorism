package com.question;

import java.util.Scanner;

public class Huiwenshu_test {
	//	回文数的判断；
//	核心算法是如何取出各个位的数字
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		for(int i=10000;i<100000;i++){
			int ge=i%10;
			int shi=i/10%10;
			int qian=i/10/10/10%10;
			int wan=i/10/10/10/10%10;
			if(ge==wan&&qian==shi){
				System.out.println(i);
			}
		}

		System.out.println("输入你个五位数：");
		int x=scan.nextInt();
		int ge=x%10;
		int shi=x/10%10;
		int qian=x/10/10/10%10;
		int wan=x/10/10/10/10%10;
		if(ge==wan&&qian==shi){
			System.out.println("这个数是回文数");
		}else{
			System.out.println("这个数不是个回文数");
		}

	}

}
