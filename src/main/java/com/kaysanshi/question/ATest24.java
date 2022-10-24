package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:03
 * desc:在控制台输入一个7位以上的正整数，获取之后取4~7位。
 **/
public class ATest24 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个7位以上的正整数：");
        long a = s.nextLong();
        String ss = Long.toString(a);
        char[] ch = ss.toCharArray();
        int j = ch.length;
        if (j < 7) {
            System.out.println("输入错误！");
        } else {
            System.out.println("截取从右端开始的4～7位是：" + ch[j - 7] + ch[j - 6]
                    + ch[j - 5] + ch[j - 4]);
        }
    }
}
