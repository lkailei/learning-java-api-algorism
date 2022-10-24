package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:14
 * desc:输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 **/
public class ATest38 {
    public static void main(String[] args) {
        int digital = 0;
        int character = 0;
        int other = 0;
        int blank = 0;
        char[] ch = null;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                digital++;
            } else if ((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] > 'A'
                    && ch[i] <= 'Z') {
                character++;
            } else if (ch[i] == ' ') {
                blank++;
            } else {
                other++;
            }
        }
        System.out.println("数字个数: " + digital);
        System.out.println("英文字母个数: " + character);
        System.out.println("空格个数: " + blank);
        System.out.println("其他字符个数:" + other);
    }
}
