package com.shugou;

import com.shugou.LinkedList;
import com.shugou.person;

public class Test {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		person p=new person();
		p.setCall("123456");
		p.setMail("010101@qq.com");
		p.setPhone("1822649989");
		p.setSex("男");
		p.setName("李华");
		list.add(p);
		System.out.println(list);
		person p1=new person("李磊","男","1833699799","258260","0120102@qq.com");
		person p2=new person("张华","女","1863696999","562260","0120105@qq.com");
		person p3=new person("李想","女","1866698429","850260","0120106@qq.com");
		//增加；
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println(list);
		//删除
		list.remove(0);
		System.out.println(list);
		//插入；
		list.insert(0, p1);
		System.out.println(list);
		//替换；
		list.modify(1, p3);
		System.out.println(list);
		list.get(p2);
		

	}

}
