package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:14
 * desc:利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示
 **/
public class ATest34 {
    public static void main(String[] args) {
        int x;
        char grade;
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个成绩: ");
        x = s.nextInt();
        grade = x >= 90 ? 'A' : x >= 60 ? 'B' : 'C';
        System.out.println("等级为：" + grade);
    }
}
