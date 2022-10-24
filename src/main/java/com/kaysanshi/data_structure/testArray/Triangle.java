package com.kaysanshi.data_structure.testArray;

/**
 * 递归调用
 * 三角形的的数列
 *
 * @author leoill
 * @date 2019年4月27日
 */
public class Triangle {

    public static int getNumber(int n) {
        int total = 0;

        while (n > 0) {
            total = total + n;
            n--;
        }
        return total;
    }

    /**
     * 递归调用
     *
     * @param n
     * @return
     */
    public static int getNubmerByRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            //依次递归本身
            return n + getNubmerByRecursion(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Triangle.getNumber(3));
        System.out.println(Triangle.getNubmerByRecursion(3));
    }
}
