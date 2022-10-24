package com.kaysanshi.question;

/**
 * user:kay三石
 * time: 14:53
 * desc:
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
 **/
public class ATest3 {
    public static void main(String[] args) {
        double h = 100, s = 100;
        for (int i = 1; i < 10; i++) {
            s = s + h; //计算路程
            h = h / 2; // 每次反弹的高度
        }
        System.out.println("经过路程：" + s);
        System.out.println("反弹高度：" + h / 2);
    }
}
