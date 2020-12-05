package com.question;

import java.util.Arrays;

public class Array_oop  implements Comparable<Object>{
	//实现对对象的排序
	@Override
	public int compareTo(Object o) {//核心比较算法 0,<0,>0
		Array_oop obj=(Array_oop)o;
	        /*if(this.age>obj.age){//按照age从小到大排
	            return 1;
	        }
	        else if(this.age=<obj.age){
	            return -1;
	        }*/
		//return -(this.age-obj.age);//按照age从大到小排
		//return this.age-obj.age;//按照age从小到大排
//	    	三目运算法
		return this.age-obj.age==0?this.name.compareTo(obj.name):this.age-obj.age;
		//按照age从小到大排,如果年龄相等按照name的字典序排序
	}

	int age;
	String name;
	Array_oop(){

	}
	public Array_oop(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Array_oop a[]={
				new Array_oop(6,"Tom"),
				new Array_oop(6,"Ahh"),
				new Array_oop(11,"Marry"),
				new Array_oop(9,"Mike")
		};
		Arrays.sort(a);//对象数组的排序和对象数组的二分查找
		for(Array_oop i:a){
			System.out.println(i.getName());
		}
		System.out.println(Arrays.binarySearch(a,new Array_oop(11,"Marry")));
	}

}
