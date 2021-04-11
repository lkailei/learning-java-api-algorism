package com.kaysanshi.data_structure.shugou;

public class person {
	private String name;
	private String sex;
	private String phone;
	private String call;
	private String mail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return " ????:" + name + " ???:" + sex + " ????绰:" + phone + " ?绰:" + call + " ????:" + mail+"\n";
	}
	public person(String name, String sex, String phone, String call, String mail) {
		
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.call = call;
		this.mail = mail;
	}
	public person() {
		// TODO Auto-generated constructor stub
	}
	

}
