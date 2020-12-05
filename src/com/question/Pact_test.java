package com.question;

import java.util.Scanner;
//�������������Լ��;�̳���Ӧ��;
public class Pact_test {
	public void test(int a, int b){
		int t=1;
		for(int i=2;i<=a&&i<=b;i++){
			while(a%i==0&&b%i==0){//whileѭ����ͨ��ö�ٰ����е�����г���;
				t*=i;
				a=a/i;
				b=b/i;
			}
		}
		System.out.println(t);
	}
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int x=scanner.nextInt();
		int y=scanner.nextInt();
		Pact_test pact_test=new Pact_test();
		pact_test.test(x, y);
	}

}
