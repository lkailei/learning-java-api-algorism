package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:59
 * desc:第1个人10岁，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
 **/
public class ATest12 {
    public static void main(String[] args) {
        System.out.println(computeAge(8));
    }

    public static int computeAge(int n) {
        if (n == 1)
            return 10;
        return computeAge(n - 1) + 2;
    }
}
