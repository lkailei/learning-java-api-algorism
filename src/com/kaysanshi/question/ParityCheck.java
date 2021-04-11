package com.kaysanshi.question;

import java.util.Scanner;

/**
 * 判断是奇数还是偶数
 */
public class ParityCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);//创建输入流扫描；
        System.out.println("请输入一个整数：");
        long number = scan.nextLong();//用于接收用户输入的整数；
        scan.close();
        String check = (number % 2 == 0) ? "这个数是：偶数" : "这个数是：奇数";
        System.out.println(check);
    }


}
