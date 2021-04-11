package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:02
 * desc:控制台获得两个字符串，连接后打印出来
 **/
public class ATest18 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str1 = s.nextLine();
        System.out.print("请再输入一个字符串：");
        String str2 = s.nextLine();
        String str = str1 + str2;
        System.out.println("连接后的字符串是：" + str);
    }
}
