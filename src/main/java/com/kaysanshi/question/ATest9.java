package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:57
 * desc:
 * 求100之内的素数。
 * //使用除sqrt(n)的方法求出的素数不包括2和3
 **/
public class ATest9 {
    public static void main(String[] args) {
         new ATest9().m1();
        // new ATest9().m2();
    }
    public void m1() {
        boolean b = false;
        System.out.print(2 + " ");
        System.out.print(3 + " ");
        for (int i = 3; i < 100; i += 2) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if (b) {
                System.out.print(i + " ");
            }
        }
    }

    // 该程序使用除1位素数得2位方法，运行效率高通用性差。
    public void m2() {
        int[] a = new int[] { 2, 3, 5, 7 };
        for (int j = 0; j < 4; j++)
            System.out.print(a[j] + " ");
        boolean b = false;
        for (int i = 11; i < 100; i += 2) {
            for (int j = 0; j < 4; j++) {
                if (i % a[j] == 0) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if (b) {
                System.out.print(i + " ");
            }
        }
    }
}
