package com.kaysanshi.question;

public class JiaoChe extends Car {
	public int day;
	public int getName(int name){
		this.name=name;
		return name;
	}
	public int getType(int type){
		this.type =type;
		return type;
	}
	public int getMoney(int name,int type,int day){
		if(name==1){
			if(type==1){
				money=500*day;
			}
		}
		else if(name==2){
			if(type==2){
				money=300*day;
			}
		else{
			if(type==3){
				money=600*day;
				}
			}
		}
		return money;
	}
}
