package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:14
 * desc:编写一个函数，输入n为偶数时，调用函数求12+14+...+1n,当输入n为奇数时，调用函数11+13+...+1n
 **/
public class ATest32 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个正整数 n= ");
        int n = s.nextInt();
        System.out.println("相应数列的和为：" + sum(n));
    }
    public static double sum(int n) {
        double res = 0;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2) {
                res += (double) 1 / i;
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                res += (double) 1 / i;
            }
        }
        return res;
    }
}
