package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 14:56
 * desc:
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 * a=3,n=5
 * s=3+33+333+3333+33333
 * a1,a2,a3,a4,a5
 * a1=a
 * a2=a*10+a=33=sum
 * a3=10*a2+a=333
 * a4=10*a3+a=3333
 * a5=10*a4+a=33333
 * 2+22=24
 *
 **/
public class ATest8 {
    public static void main(String[] args) {
        long a, b = 0, sum = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("输入数字a的值： ");
        a = s.nextInt();
        System.out.print("输入相加的项数：");
        int n = s.nextInt();
        int i = 0;
        while (i < n) {
            b = b + a; //
            sum = sum + b;// b
            a = a * 10;
            ++i;
        }
        System.out.println(sum);
    }
}
