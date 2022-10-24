package com.kaysanshi.question;

import java.util.Scanner;

public class Test_Random {
    //猜数字
    public static void main(String[] args) {
        System.out.println("来玩会游戏，现在开始");
        int x = (int) (Math.random() * 100) + 1;
        System.out.println("请输入你猜的数：");
        Scanner scan = new Scanner(System.in);
        int i = 1;
        while (i <= 10) {
            int input = scan.nextInt();
            if (input == x) {
                System.out.println("恭喜你答对了！！");
                break;
            } else if (input > x) {
                System.out.println("你猜的数有点大；");
            } else if (input < x) {
                System.out.println("你猜的数有点小了；");
            }
            i++;
            if (i == 10) {
                System.out.println("你个渣渣真笨！！！");
                System.out.println("我不和你玩了，<嘎嘎嘎>");
                break;
            }
        }

    }

}
