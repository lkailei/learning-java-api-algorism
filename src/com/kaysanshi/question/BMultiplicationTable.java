package com.kaysanshi.question;

public class BMultiplicationTable {
    //九九乘法表
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) { // 循环控制变量从1到9
            for (int j = 1; j <= i; j++) { // 第二层循环控制变量与第一层最大索引相等
                //product=i*j;
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

}
