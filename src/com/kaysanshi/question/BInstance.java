package com.kaysanshi.question;

import java.math.BigDecimal;

/**
 * user:kay三石
 * time: 12:23
 * desc: 计算1+1/2!+1/3!+1/4!+....+1/20!=
 * 因为数值比较大所以要用到浮点数的精度
 **/
public class BInstance {
    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(0.0);
        BigDecimal factorial = new BigDecimal(1.0);
        int i=1;
        while(i<20){
            // 累计阶乘的和
            sum =sum.add(factorial);
            ++i;
            // 计算阶乘
            factorial=factorial.multiply(new BigDecimal(1.0/i));
        }
        System.out.println("1+1/2!+1/3!+1/4!+....+1/20!= \n"+ sum);
    }
}
