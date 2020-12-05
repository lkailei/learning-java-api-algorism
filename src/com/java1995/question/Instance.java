package com.java1995.question;

/**
 * 用Java来写水仙花数
 * 特别注意各个位上的数的计算
 * 百位时取整；十位时求余取整；个位是取余；
 */
public class Instance {
    public static void main(String[] args) {
        int a, b, c;
        System.out.println("输出100到1000中的水仙花数");
        for (int i = 100; i < 1000; i++) {
            a = i / 100;//取出百位；
            b = i % 100 / 10;//取出十位；
            c = i % 10;//取出个位；
            if ((a * a * a) + (b * b * b) + (c * c * c) == i)
                System.out.println(i + "\t");
        }
    }

}
