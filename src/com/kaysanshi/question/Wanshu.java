package com.kaysanshi.question;

import java.util.Scanner;

//求一个数内的完数;未将其完善
public class Wanshu {
	public void test(int n){
		int s,j;
		int a[]=new int[2000];//存放因子数量要相对大些;
		for(int i=1;i<=n;i++){
			int k=0;s=1;
			for(j=2;j<i;j++){
				if(i%j==0){
					s+=j;//保存因子的和;
					a[k]=j;//因子放到数组中;
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
