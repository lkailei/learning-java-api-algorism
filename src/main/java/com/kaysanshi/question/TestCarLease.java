package com.kaysanshi.question;

import java.util.Scanner;

public class TestCarLease {
	public static void main(String[] args) {
		System.out.println("欢迎来到汽车租借公司：");
		System.out.println("请其输入要租借的类型1.轿车。2.客车");
		Scanner scan = new Scanner(System.in);
		int name1= scan.nextInt();
		if(name1==1){
			System.out.println("请输入租借汽车的品牌（1.宝马  2.别克）");
			int name=scan.nextInt();
			System.out.println("请输入轿车的品牌类型(1.550 2.林荫大道 3.商务GL)");
			int type= scan.nextInt();
			System.out.println("请输入租借的天数：");
			int day=scan.nextInt();
			scan.close();
			JiaoChe p=new JiaoChe();
			p.getName(name);
			p.getType(type);
			p.day=day;
			p.getMoney(p.getName(),p.getType(),p.day);
			System.out.println("你这次需要支付："+p.getMoney(p.getName(),p.getType(),p.day)+"元");
			System.out.println("欢迎您的下次光临！！！");
		}else if(name1==2){
			System.out.println("请输入租借的品牌1.金杯。2.金龙");
			int name=scan.nextInt();
			System.out.println("请输入租借的位数：");
			int sit=scan.nextInt();
			System.out.println("请输入租借的天数：");
			int day=scan.nextInt();
			KeChe p1=new KeChe();
			scan.close();
			p1.getName(name);
			p1.sit =sit;
			p1.day=day;
			p1.getMoney(p1.getName(),p1.sit,p1.day);
			System.out.println("你这次需要支付："+p1.getMoney(p1.getName(),p1.sit,p1.day)+"元");
			System.out.println("欢迎您的下次光临！！！");
		}
	}
}
