package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 14:54
 * desc:判断一个整数能被几个9整除？
 * 9，18,36,
 **/
public class ATest5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = s.nextInt();
        int tmp = num;
        int count = 0;
        // for(单次表达式;循环条件;末尾循环体){中间循环体}
        // 求解单次表达式;求解循环条件，若其值为真，则执行 for 语句中指定的中间循环体，然后求末尾循环体；若循环条件（表达式2）值为假，则结束循环；
        // 求末尾循环体，继续执行循环条件
        for (int i = 0; tmp % 9 == 0;) {
            tmp = tmp / 9;
            count++;
        }
        System.out.println(num + " 能够被 " + count + " 个9整除。");
    }
}
