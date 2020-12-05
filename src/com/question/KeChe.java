package com.question;

public class KeChe extends Car {
	int sit;
	public int day;
	public int getName(int name){
		this.name=name;
		return name;
	}
	public int getMoney(int name ,int sit,int day){
		if(name==1){
			if(sit>16){
				money=1500*day;
			}else{
				money=800*day;
			}
		}else{
			if(sit>16){
				money=1500*day;
			}else{
				money=800*day;
			}
		}
		return money;
	}

}
