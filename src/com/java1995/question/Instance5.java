package com.java1995.question;

import java.util.Scanner;

public class Instance5 {
    //不用第三方变量实现两个数的交换
    public static void main(String[] args) {
        int a = 100;
        int b = 10;
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("a=" + a + "b=" + b);
        System.out.println("请输入要交换的数字");
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        m = m * n;
        n = m / n;
        m = m / n;
        scan.close();
        System.out.println("交换后的数字为:m=" + m + ",n=" + n);
    }

}