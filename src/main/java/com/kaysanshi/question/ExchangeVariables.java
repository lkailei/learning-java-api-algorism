package com.kaysanshi.question;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * 不使用第三方变量交换变量：
 * 思想：两数相乘：n*m = t   m=t/m  这时m为n的值了，但是这时候把n的值给m    n=t/m    这其实就是m的值 把 m的值给n了
 *  10(n) *7(m) = 70
 *  n= 70/10 =7
 *  m=70/n=70/7=10
 */
public class ExchangeVariables {
    //不用第三方变量实现两个数的交换
    public static void main(String[] args) {
        int a = 100;
        int b = 10;
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("a=" + a + "b=" + b);
        System.out.println("请输入要交换的数字");
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        m = m * n;
        n = m / n;
        m = m / n;
        scan.close();
        System.out.println("交换后的数字为:m=" + m + ",n=" + n);
    }

    /**
     * 交换两个数值
     * @param i
     * @param j
     */
    public void test(int i,int j){
        i=i*j;
        j=i/j;
        i=i/j;
        System.out.println("");
        System.out.println(i+","+j);
    }

}