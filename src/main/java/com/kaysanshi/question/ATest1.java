package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:52
 * desc: 判断101-200之间有多少个素数，并输出所有素数。
 * 什么是素数（质数）：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
 * 1，3，5，7，9，11
 *
 * 用一个数x去除2至sqrt(x)（即该数的开方），如果能被整除， 则表明此数不是素数，反之是素数
 **/
public class ATest1 {
    public static void main(String[] args) {
        int count = 0;
        // 101 每次+2
        for (int i = 101; i < 200; i += 2) {
            // 每次保证i都是个素数
            boolean b = false;
            //取得平方根
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // 不是素数
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if (b) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("素数个数是: " + count);
    }
}
