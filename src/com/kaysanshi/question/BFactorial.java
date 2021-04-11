package com.kaysanshi.question;

import java.util.Scanner;

/**
 * 计算阶乘
 */
public class BFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你想求得阶乘数：");
        double n = scan.nextDouble();//  所求得数要特别大必须把int
        //类型改为double类型
        scan.close();
        double ride = 1;
        for (int i = 1; i <= n; i++) {
            ride *= i;
        }
        System.out.println(ride);
    }
}

