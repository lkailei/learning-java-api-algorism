package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:55
 * desc: 求1+2!+3!+...+20!的和  1+2+6
 *  2=1*2
 *  3=3*2*1
 *  4=4*3*2*1
 *  5=5*4*3*2*1
 *  1+2!
 *  i=1开始 i<=2
 *  sum=sum*i
 **/
public class ATest7 {
    public static void main(String[] args) {
        long sum = 0;// 1,
        long fac = 1; // 1
        for (int i = 1; i <= 20; i++) {
            // 计算前面一项的和
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);
    }
}
