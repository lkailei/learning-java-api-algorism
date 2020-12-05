package com.test.question;

/*
 * page77:创建一个类并且包含未初始化的String引用；验证为空；
 * ：创建一个类的时候定义时就被初始化的String域以及另一个通过构造器初始化比较不同；
 */
public class InStance2 {
	//	初始化其实就是在new对象的那一刻时就被初始化了；会自动调用构造器；
	String s;
	InStance2(){
//		s="hello everybody";//验证二是需要用到；
		System.out.println(s);
	}
	String s1="hello java";//会在构造器中已经初始化
	public static void main(String[] args) {
		InStance2 sr=new InStance2();
		System.out.println(sr.s);
		System.out.println(sr.s1);
	}

}
