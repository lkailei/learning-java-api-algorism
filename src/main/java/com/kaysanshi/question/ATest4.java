package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:53
 * desc:一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3。.编程找出1000以内的所有完数。 1,2*3=6, 1,2,3,
 * 1+2+14+4+7=28=2*14=4*7
 **/
public class ATest4 {
    public static void main(String[] args) {
        System.out.println("1到1000的完数有： ");
        for (int i = 1; i < 1000; i++) {
            int t = 0;
            // 只需找到其中的一办就可以
            for (int j = 1; j <= i / 2; j++) {
                // 求i的因子
                if (i % j == 0) {
                    t = t + j;
                }
            }
            if (t == i) {
                System.out.print(i + "     ");
            }
        }
    }
}
