package com.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentAdmin {

	public static void main(String[] args) {
		ArrayList<Student>  list=new ArrayList<Student>();
		while(true){
			System.out.println("$$欢迎来到学生管理系统$$");
			System.out.println("$$1.查看学生信息 $$");
			System.out.println("$$2.添加学生 $$    ");
			System.out.println("$$3.删除学生$$");
			System.out.println("$$4.修改信息&&");
			System.out.println("&&0.退出&&");
			Scanner scan=new Scanner(System.in);
			String n=scan.nextLine();
			switch(n){
				case "1":findAllStudent(list);break;
				case "2":addStudent(list);break;
				case "3":removeStudent(list);break;
				case "4":updateStudent(list);break;
				default:System.out.println("谢谢你的使用");
					System.exit(0);break;
			}
		}

	}
	/*
	 *
	 */
//	修改学生信息；
	public static void updateStudent(ArrayList<Student> list){
		Scanner scan =new Scanner(System.in );
		System.out.println("请你输入你要修改的学号：");
		String id=scan.nextLine();
		int index=-1;
		for(int x=0;x<list.size();x++){
			Student s=list.get(x);
			if(id.equals(s.getId())){
				index=x;
				break;
			}
		}
		if(index==-1){
			System.out.println("没有这个学生信息");
		}else{
			System.out.println("请输入姓名");
			String name=scan.nextLine();
			System.out.println("请输入年领");
			String age=scan.nextLine();
			System.out.println("请输入地址");
			String address=scan.nextLine();
			//创建学生
			Student s= new Student();
			s.setId(id);
			s.setName(name);
			s.setAge(age);
			s.setAddress(address);
//			修改集合中的学生对象
			list.set(index, s);
			System.out.println("修改成功");
		}
	}
	//	增加学生信息
	public static void addStudent(ArrayList<Student> list){
		Scanner scan=new Scanner(System.in);
		String id;
		while(true){
			System.out.println("请输入学生的学号：");
			id=scan.nextLine();
			boolean flag=false;
			for(int i=0;i<list.size();i++){
				Student s=list.get(i);
				if(id.equals(s.getId())){
					flag=true;
					break;
				}
			}
			if(flag){
				System.out.println("你输入的学号已被占用请重新输入");
			}else{
				break;
			}
		}
		Student s=new Student();
		System.out.println("请你输入姓名：");
		String name=scan.nextLine();
		System.out.println("请你输入你的年龄");
		String age=scan.nextLine();
		System.out.println("请你输入地址：");
		String address=scan.nextLine();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		list.add(s);
		System.out.println("添加成功");
	}
	//	删除学生信息
	public static void removeStudent(ArrayList<Student> list){
		Scanner scan=new Scanner(System.in);
		System.out.println("请你输入你要删除的学号");
		String id=scan.nextLine();
		int index=-1;//一个索引标志
		for(int i=0;i<list.size();i++){
			Student s=list.get(i);
			if(id.equals(s.getId())){
// 				如果id相等则令i的值传给list的remove方法；
				index=i;
				break;
			}
		}
		if(index==-1){
			System.out.println("没有这个学生的信息");
		}else{
			list.remove(index);
			System.out.println("删除成功");
		}

	}
	//	查询学生信息；
	public static void findAllStudent(ArrayList<Student> list){
//		如果长度为0，则没有学生信息；
		if(list.size()==0){
			System.out.println("没有学生信息可以查询");
			return;
		}
		System.out.println("学号\t\t姓名\t年龄\t地址 ");
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			Student s=it.next();
			System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
		}
	}

}
