package com.kaysanshi.jzoffer;

/**
 * user:kay三石
 * time: 21:33
 * desc:实现一个方法来判断是否是2的整数次幂(如16是2的4次方，返回true) 尽可能使用性能高的算法
 **/
public class IPowerOf2 {

    public static  boolean isPowerOf2(int num){
        int temp=1;
        while (temp<=num){
            if (temp == num){
                return true;
            }
            temp=temp*2;
        }
        return false;
    }

    /**
     * 递归进行相除
     * @param num
     * @return
     */
    public static boolean isPowerOf2v1(int num){
        if(num==1){
            return true;
        }
        num=num/2;
        return isPowerOf2(num);
    }

    /**
     * 按位与运算: 将其转为2进制，然后通过与原数的减一的二进制做与运算即可算出是否为2的次幂
     * @param num
     * @return
     */
    public static boolean isPowerOf2v2(int num){
        return (num&num-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(IPowerOf2.isPowerOf2(16));
        System.out.println(IPowerOf2.isPowerOf2v1(2048));
        System.out.println(IPowerOf2.isPowerOf2v2(18));
    }

}
