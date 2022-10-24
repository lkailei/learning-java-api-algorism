package com.kaysanshi.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 计算数组中的最大值
 */
public class Test_arrays_max {
//	主要理解进行输入时的代码
//BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
//arr[i] = Integer.parseInt(stdin.readLine());
	public static void main(String[] args)  {
		int arr[]=new int[10];
		System.out.println("请输入你的数组的值回车键要：");
		for(int i=0;i<arr.length;i++){
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
			try {
				arr[i] = Integer.parseInt(stdin.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		System.out.println(max);

	}

}
