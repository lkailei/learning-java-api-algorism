package com.java1995.question;

public class TestConstant {
    public static void main(String[] args) {
        final int APPLE_PREICE_PER_KM;//声明常量
        int weightOfApple;//声明变量
        int money;
        weightOfApple = 5;//后面的变量会把前面的覆盖掉
        weightOfApple = 6;
        weightOfApple = 8;
        APPLE_PREICE_PER_KM = 3;
        money = APPLE_PREICE_PER_KM * weightOfApple;
        System.out.println("买苹果花了" + money + "元");
    }
}
