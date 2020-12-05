package com.question;

import java.util.Scanner;

/*
 * 防数独游戏
 */
public class Shuduyouxi_test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个奇数");
		int n=scan.nextInt();
		int [][] arr= new int [n][n];
		int k=1;//每个数组的值从1开始；
		int row=0;//行数
		int col=(n-1)/2;//列数；
		arr[row][col]=k;
		while(k<n*n){//数组的最大值
			if(k%n==0){//如果k是n的倍数时
				row+=1;
			}else{
				if(row==0){//当这个数在第一行的时候另一个数在最后一行
					row=n-1;
				}else{//当这个数不在第一行时，这个数的右上方还有位置的时候
					row-=1;
				}
				if(col==n-1){//当这个数在最后一列时，下一个数在第一列
					col=0;
				}else{//当这个数不在最后一列时这个数的右上方还有位置的时候；
					col+=1;
				}
			}
			arr[row][col]=++k;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
