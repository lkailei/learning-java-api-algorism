package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 11:44
 * desc: 给定一个月份判断这个月份所在的季节
 **/
public class BJudgeMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个月份然后，我会输出季节");
        int month = scanner.nextInt();
        switch (month){
            case 12:
            case 1 :
            case 2:
                System.out.println("你输入的月份属于冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("你输入的月份属于春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("你输入的月份是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("你输入的月份是秋季");
                break;
            default:
                System.out.println("没有月份");
        }
    }
}
