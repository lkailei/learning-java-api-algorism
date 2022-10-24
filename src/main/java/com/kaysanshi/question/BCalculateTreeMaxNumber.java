package com.kaysanshi.question;
/*
 * 判断三个数的最大值
 */

import java.util.Scanner;

public class BCalculateTreeMaxNumber {
    public static void main(String[] args) {
        System.out.println("请输入三个数");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();
        System.out.println();
        if (a > b) {
            System.out.println(a);
        } else if (a > c) {
            System.out.println(a);
        } else if (b > c) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }

}
