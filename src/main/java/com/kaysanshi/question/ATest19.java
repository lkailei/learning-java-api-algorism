package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 15:02
 * desc:利用递归方法求5!
 **/
public class ATest19 {
    public static void main(String[] args) {
        int n = 5;
        rec fr = new rec();
        System.out.println(n + "! = " + fr.rec(n));
    }
}
class rec {
    public long rec(int n) {
        long value = 0;
        if (n == 1) {
            value = 1;
        } else {
            value = n * rec(n - 1);
        }
        return value;
    }
}