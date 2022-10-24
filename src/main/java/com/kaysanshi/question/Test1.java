package com.kaysanshi.question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//编写算法打印图形,对角线排列的是有序进行的;
////思想是转换为数组中的小标;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a =new int[100][100];
		System.out.println("输入列数");
		Scanner scanner=new Scanner(System.in);
		int	n=scanner.nextInt();
			int k=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n+1-i;j++){
				a[i-1+j][j]=k;
				k++;
			}
		}
		for(int i=1;i<=n;i++){
			System.out.println();
			for(int j=1;j<=i;j++){
				System.out.print(a[i][j]+" ");
			}
		}
	
		
			
	}

}
