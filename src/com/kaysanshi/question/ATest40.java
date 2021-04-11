package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 15:14
 * desc:有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 **/
public class ATest40 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 6, 14, 25, 36, 37, 55 };
        int[] b = new int[a.length + 1];
        int t1 = 0, t = 0;
        int i = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = s.nextInt();
        if (num >= a[a.length - 1]) {
            b[b.length - 1] = num;
            for (i = 0; i < a.length; i++) {
                b = a;
            }
        } else {
            for (i = 0; i < a.length; i++) {
                if (num >= a[i]) {
                    b[i] = a[i];
                } else {
                    b[i] = num;
                    break;
                }
            }
            for (int j = i + 1; j < b.length; j++) {
                b[j] = a[j - 1];
            }
        }
        for (i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
