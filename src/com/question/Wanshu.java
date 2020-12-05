package com.question;

import java.util.Scanner;

//��һ�����ڵ�����;δ��������
public class Wanshu {
	public void test(int n){
		int s,j;
		int a[]=new int[2000];//�����������Ҫ��Դ�Щ;
		for(int i=1;i<=n;i++){
			int k=0;s=1;
			for(j=2;j<i;j++){
				if(i%j==0){
					s+=j;//�������ӵĺ�;
					a[k]=j;//���ӷŵ�������;
					k++;
				}
				}
				if(i==s){
					System.out.print( s+" it is:"+1);
					for(j=0;j<k;j++){
						System.out.print(" "+a[j]);
					}
					System.out.println();
				}
			
		}
	}
	public static void main(String[] args) {
		Wanshu w=new Wanshu();
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		w.test(x);
	}
}
