package com.kaysanshi.question;

public class Instance3 {
	//无参的构造器；
	Instance3(){
		System.out.println("我是无参的构造器是在new的时候默认调用的");
	}
	//	重载构造器
	Instance3(String s){
		System.out.println(s);
	}

	public static void main(String[] args) {
//	构造重载的时候编译器会认为你要用你自己得构造其不会去调用默认的构造器；
		Instance3 i=new Instance3();
//		从而你只能用自己的构造器
		Instance3 i3=new Instance3("hello");
//		一下方式会报错；
//		Scanner scan=new Scanner(System.in);
//		String s=scan.nextLine();
//		i3.InStance3(s);
	}

}
