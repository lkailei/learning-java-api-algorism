package com.kaysanshi.question;


/*
 * 一百子猴子报数从第三个猴子开始报数报到13的猴子退出去；然后下一个猴子从新报数依次类推；最后
 * 一个猴子就是大王；
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
