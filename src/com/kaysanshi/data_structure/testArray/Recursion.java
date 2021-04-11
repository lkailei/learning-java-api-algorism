package com.kaysanshi.data_structure.testArray;

/**
 * 递归的使用:
 * 必须调用本身的，必须有结束的标志
 *
 * @author leoill
 * @date 2019年4月27日
 */
public class Recursion {

    public static void test() {
        System.out.println("测试递归");
        test();
    }

    public static void test2(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        test2(n - 1);
    }

    public static void main(String[] args) {
        test2(100);
    }
}
