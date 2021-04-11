package com.kaysanshi.question;

import java.util.Scanner;

/*
 * finalize();的使用；finalize()方法是用来手动的强制的终结动作；
 */
public class Instance4 {
	public int getSum(int m){
		int sum = 0;
		for(int i=0;i<m;i++){
			sum+=i;
		}
		return sum;


	}

	public void finalize(){
		try {
			super.finalize();
			System.out.println("程序终止");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Instance4 i4=new Instance4();
		int m=new Scanner(System.in).nextInt();
		i4.getSum(m);

		if(i4.getSum(m)>1000){
			i4.finalize();
			System.gc();
			System.out.println(i4.getSum(m));
		}
	}

}
