package com.kaysanshi.question;

import java.util.Scanner;

public class Month_test {
	//通过输入的月份判断现在是几月份：
	public static void main(String[] args) {
		System.out.println("请你输入你要判断的月份：");
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		switch(s){
			case "1":
			case "12":
			case "2":
				System.out.println("冬季");break;
			case"3":
			case"4":
			case"5":
				System.out.println("春季");break;
			case "6":
			case"7":
			case"8":
				System.out.println("夏季");break;
			case"9":
			case"10":
			case"11":
				System.out.println("秋季");break;
			default:System.out.println("你输入的不合法");break;

		}

	}

}
