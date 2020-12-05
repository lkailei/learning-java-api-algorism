package com.java1995.question;

public class TestChang {
	public static void main(String[]args){
			/* double adouble=3.55555;
			int aint=(int)adouble;
			System.out.println(aint);
			*/
		int aint=257;//int  4字节 32位，257 表示为 00000000 00000000 00000001 00000001
		byte abyte=(byte)aint;// byte 1字节 8位；大转小时去高位；变为 00000001
		System.out.println(abyte);
	}
} 
