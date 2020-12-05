package com.question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//��д�㷨��ӡͼ��,�Խ������е���������е�;
//˼����ת��Ϊ�����е�С��;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a =new int[100][100];
		System.out.println("��������");
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
