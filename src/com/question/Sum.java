package com.question;

import java.util.Scanner;

//����׳˵ķ���һ�ĺ�:1/1-1/3!+1/5!-1/7!+.....
//˼·:���ѭ�����Ƶ��ڼ�����,�ڲ���÷������ʽ;��ĸ,����ͬʱ����;�ڽ������;
public class Sum {
	public void test(int n){
		float s=1;
		//
		for(int i=2;i<=n;i++){
			float t=1;
			//�׳˹�ʽ:
			for(int j=1;j<=2*i-1;j++){
				t=t*j;
			}
			int sign=1;
			//���ӵ�������;
			for(int j=1;j<=i+1;j++){
				sign=sign*(-1);
			}
			s=s+sign/t;
		}
		System.out.println(s);
	}
	//�ڶ��ַ�ʽ:s=Sn-1+(-1)^(n+1)An;An=(An-1)*1/(2*n-2)(2*n-1);
	public void test2(int n){
		float s=1;	float t=1;
		int sign=1;
		//
		for(int i=2;i<=n;i++){
			sign=-sign;
			t=t*(2*i-2)*(2*i-1);
			s+=sign/t;
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		Sum sum=new Sum();
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		sum.test(x);
		sum.test2(x);
	}
}
