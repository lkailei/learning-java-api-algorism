package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 11:39
 * desc: 计算闰年 ，闰年能被4整除但不能被100整除，或者能被400整除
 **/
public class BLeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要判断的年份");
        long year = scanner.nextLong();
        if (year%4 == 0&& year%100!=0 || year%400 ==0){
            System.out.println(year+"是闰年");
        }else{
            System.out.println(year+"不是闰年");
        }
    }
}
