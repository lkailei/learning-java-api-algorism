package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:52
 * desc:
 * 求0-7所能组成的奇数个数。
 * 当一个数的最后一位为奇数时，那么这个数一定为奇数，不管前面几位是什么数字。如果最后一位数为偶数，则这个数一定为偶数
 * 提示：
 * //组成1位数是4个。 1,3,5,7
 * //组成2位数是7*4个。 1,3,5,7   4个奇数。 7个数字。 4*7 28个。
 * //组成3位数是7*8*4个。 7个数字   8个数字  4个   7*8*4
 * //组成4位数是7*8*8*4个。
 **/
public class ATest2 {
    public static void main(String[] args) {
        int sum = 4;
        int j;
        System.out.println("组成1位数是 " + sum + " 个");
        sum = sum * 7;
        System.out.println("组成2位数是 " + sum + " 个");
        for (j = 3; j <= 9; j++) {
            sum = sum * 8;   // 4*7*8  // 4*7*8*8
            System.out.println("组成" + j + "位数是 " + sum + " 个");
        }
    }
    /**
     * 组成1位数是 4 个
     * 组成2位数是 28 个
     * 组成3位数是 224 个
     * 组成4位数是 1792 个
     * 组成5位数是 14336 个
     * 组成6位数是 114688 个
     * 组成7位数是 917504 个
     * 组成8位数是 7340032 个
     * 组成9位数是 58720256 个
     *
     * Process finished with exit code 0
     */
}
