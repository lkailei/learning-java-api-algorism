package com.kaysanshi.question;


/*
 * 一百猴子报数从第三个猴子开始报数报到数字为13的猴子退出去；然后下一个猴子从新报数依次类推；最后
 * 一个猴子就是大王；
 * 1，2， 3，4，5，。。。100
 *
 * 3,,4,5,6....  100
 *  3，->13
 * 3，99
 *
 * 98
 * 13，26 ，39
 * 13 , 第13猴子退出
 *  0，1，2
 *  13 26 39 .。。
 *  %13==0
 *  22 个猴子就是大王。
 */
public class AMonkeyWin_test {
	public static void main(String[] args) {
		int sum=100;

		for(int i=2;i<sum;i++){
			if(i%13==0){
				sum-=i;
				System.out.println(sum);
			}

		}

	}

}
