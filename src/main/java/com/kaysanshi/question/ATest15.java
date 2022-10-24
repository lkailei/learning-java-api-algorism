package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:01
 * desc:写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度
 *
 *
 *
 * 用的length()方法，如果不用这个方法，你还能实现吗？
 **/
public class ATest15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = s.nextLine();
        System.out.println("字符串的长度是：" + str.length());
    }
}
