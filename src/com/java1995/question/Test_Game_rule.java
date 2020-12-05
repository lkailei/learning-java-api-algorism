package com.java1995.question;
import java.util.Scanner;

public class Test_Game_rule {
/*
 * 石头剪刀布游戏
 */
public static void main(String[] args) {
	while(true){
		System.out.println("开始游戏：");
		String arr[]=new String[]{"剪刀","石头","布"};
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入：剪刀石头布");
		String s1=scan.nextLine();
		if(s1.equals("剪刀")||s1.equals("石头")||s1.equals("布")){
			int count=(int)(Math.random()*3);
			String s2=arr[count];
			getName(s1,s2);
			int flag=getName(s1,s2);
			if(flag==1){
				System.out.println("电脑出："+s2);
				System.out.println("你赢了");
			}
			if(flag==-1){
				System.out.println("电脑出："+s2);
				System.out.println("电脑赢了");
			}
			if(flag==0){
				System.out.println("电脑出："+s2);
				System.out.println("平局");
			}
		}
		else{
			if(s1.equals("exit")){
				break;
			}
			System.out.println("你输入的有误");

		}

	}
	System.out.println("你退出了游戏！！");
}
	public static int getName(String s1,String s2){
		if(s1.equals(s2)){
			return 0;
		}
		if (s1.equals("剪刀")){
			if(s2.equals("石头")){
				return -1;
			}
			if(s2.equals("布")){
				return 1;
			}
		}
		if(s1.equals("布")){
			if(s2.equals("石头")){
				return 1;
			}
			if(s2.equals("剪刀")){
				return -1;
			}
		}
		if(s1.equals("石头")){
			if(s2.equals("剪刀")){
				return 1;
			}
			if(s2.equals("布")){
				return -1;
			}
		}
		return 0;
	}
}
