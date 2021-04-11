package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 14:54
 * desc:判断一个整数能被几个9整除？
 **/
public class ATest5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = s.nextInt();
        int tmp = num;
        int count = 0;
        for (int i = 0; tmp % 9 == 0;) {
            tmp = tmp / 9;
            count++;
        }
        System.out.println(num + " 能够被 " + count + " 个9整除。");
    }
}
