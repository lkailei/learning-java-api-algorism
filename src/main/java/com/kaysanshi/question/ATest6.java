package com.kaysanshi.question;

import java.util.Scanner;

/**
 * user:kay三石
 * time: 14:55
 * desc:
 * 一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 *  质因数 [3]  就是一个数的约数，并且是质数
 *   90/1=90
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。   k,2,-n n%k==0  可以整除，那就可以求出这个数的因子，n=n/k
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。 n%k ==0  n=n/k 除数 。
 **/
public class ATest6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请键入一个正整数:     ");
        int n = s.nextInt();
        int k = 2;// k从1开始了没任何意义
        System.out.print(n + "=");
        while (k <= n) {
            if (k == n) {
                // 如果k循环到和输入的相同了则中断
                System.out.println(n);
                break;
            } else if (n % k == 0) {   // 10%2==0 n&3
                // 如果n对取于等于0则说明可以整除
                System.out.print(k + "*"); // 2
                n = n / k; // n=5
            } else {
                k++; //k=3,4,5
            }
        }
    }
}
