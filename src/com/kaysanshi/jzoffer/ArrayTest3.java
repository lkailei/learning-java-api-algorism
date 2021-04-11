package com.kaysanshi.jzoffer;

/**
 * @Author kay三石
 * @date:2019/6/10
 * 给定一个数组A[0,1,...n]请构建一个数组B[0，1,...,n-1]其中B的元素B[i]=A[0]A[1]...A[i-1]..A[n-1]。要求不能使用除法
 * */
public class ArrayTest3 {

    public int[] multiply(int[] A){
        int n=A.length;
        int[] B=new int[n];
        //从左往右累乘
        for (int i=0,product=1;i<n;product*=A[i],i++){
            B[i]=product;

        }
        //从右往左累乘
        for (int i=n-1,product=1;i>=0;product*=A[i],i--){
            B[i]*=product;
        }
        return B;
    }
}
