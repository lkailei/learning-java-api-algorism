package com.question;

public class Test_arrays_sum {
	//创建一个二维数组将二维数组所有元素的和输出：
	public static void main(String[] args) {
		int arr[][]=new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("求所有的元素的和：");
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
		System.out.println("第二种方法计算：");
		for(int x[]:arr){
			for(int e:x){
				System.out.print(e+" ");
			}
			System.out.println();
		}
		System.out.println("用第二种方法计算和:");
		int sum1=0;
		for(int x[]:arr){
			for(int e:x){
				sum1+=e;
			}
		}
		System.out.println(sum1);
	}

}
