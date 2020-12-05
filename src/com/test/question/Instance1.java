package com.test.question;

/*
 * 吸血鬼数字；指的位数为为偶数的数字，可有一对数字相乘，并且这些数字是有这写数字各包含一半的位数的
 * 数字此题思想可以但还有不足之处
 */

public class Instance1 {
	public void getBloodMath(){
		for(int i=1000;i<10000;i++){
			int ge=i%10;
			int shi=i/10%10;
			int bai=i/10/10%10;
			int qian=i/10/10/10%10;
			if((shi*10+ge)*(bai*10+qian)==i||(shi*10+qian)*(bai*10+ge)==i||(shi*10+qian)*(qian*10+ge)==i
			)
				System.out.print(i+" ");
		}
	}

	public static void main(String[] args) {
		Instance1 q=new Instance1();
		q.getBloodMath();
	}

}
