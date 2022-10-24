package com.kaysanshi.question;

import java.util.Scanner;

public class Score_test {
	//	思维方法的
//评委评分：十个评委去掉一个最高分一个最低分求其最终得分
//	获取最大值：比较两个获取值得方法；
	public int getMax(int[] score){
		int Max ;
		Max=score[0];//与score[0]=max;区分不一样的方式；错误；
		for(int i=0;i<score.length;i++){
			for(int j=0;j<score.length-i;j++){
				if(score[j]>Max){
					Max=score[j];
				}
			}
		}
		return Max;
	}
	//	获取最小值
	public int getMin(int[] score){
		int Min ;
		Min=score[0];
		for(int i=0;i<score.length;i++){
			for(int j=0;j<i;j++){
				if(score[j]<Min){
					Min=score[j];
				}
			}
		}
		return Min;
	}
	public int getSum(int[] score){
		int sum=0;
		for(int i=0;i<score.length;i++){
			sum+=score[i];
		}
		return sum;
	}
	/*
	 *
	 */
	public static void main(String[] args) {
		Score_test st=new Score_test();
		int score[]=new int[10];
		for(int i=0;i<score.length;i++){
			Scanner scan=new Scanner(System.in);
			System.out.println("请输入第"+(i+1)+"位评委的打分：");
			score[i]=scan.nextInt();
		}
		System.out.println("初始得分为：");
		for(int x:score){
			System.out.print(x+" ");
		}
		System.out.println("初始总的分：");
		System.out.println(st.getSum(score));
		double getscore=0;
		int max=st.getMax(score);
		System.out.println(max);
		int min=st.getMin(score);
		System.out.println(min);
		int sum=st.getSum(score);
		System.out.println(sum-max-min);
		getscore=(sum-max-min)/(double)(score.length-2);
		System.out.println("这个选手的最终得分为："+getscore);
	}
}
