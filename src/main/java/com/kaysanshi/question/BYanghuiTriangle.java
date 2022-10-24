package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 11:53
 * desc: 杨辉三角 ： 其基本特性是两侧数值均为 1，其他位置是其正上方与左上角数值之和
 * 1
 * 1 1
 * 1 2  1
 * 1 3  3  1
 * 1 4  6  4 1
 * 1 5 10 10 5 1
 **/
public class BYanghuiTriangle {
    public static void main(String[] args) {
        int triangle[][] = new int[8][];// 创建一个二维数组
        // 遍历二维数组的第一层
        for(int i=0;i<triangle.length;i++){
            // 每层的数组
            triangle[i]=new int[i+1];
            // 遍历第二层
            for(int j=0;j<=triangle[i].length-1;j++){
                // 将两侧的数组元素赋值为1
                if(i==0|| j==0 || j== triangle[i].length-1){
                    triangle[i][j]=1;
                }else{
                    triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
                }
                System.out.print(triangle[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
