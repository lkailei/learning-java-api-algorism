package com.kaysanshi.question;

/**
 * @Author kay三石
 * @date:2020/11/8
 */
public class BFactAndHanoi {
    public static void main(String[] args) {
        int result = 0;
        int n = 5;
        result = fact(n);
        System.out.println(result);

        hanoi(2, 1, 2, 3);
    }

    /**
     * 递归函数求阶乘
     *
     * @param n
     * @return
     */
    private static int fact(int n) {
        // 递归必须确定结束条件
        if (n < 2) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * 汉诺塔
     *
     * @param n   盘子数
     * @param src 元盘子
     * @param mid 中间盘子
     * @param tar 目标盘子
     */
    private static void hanoi(int n, int src, int mid, int tar) {
        // 确定结束条件
        if (n == 1) {
            System.out.println(src + "-->" + tar);
        } else {
            hanoi(n - 1, src, tar, mid); // 把n-1个盘子从元盘子借助目标柱子放到中间柱子
            hanoi(1, src, mid, tar); // 把一个盘子从原主借助中间住放到目标住
            hanoi(n - 1, mid, src, tar); // 把n-1个盘子从中间住借助源住放到目标住
        }

    }
}
