package com.kaysanshi.shangguigu;

/**
 * @Author kay三石
 * @date:2019/6/2
 * 枚举类型构造单例：该例的实例对象限定为几个
 * 我们可以限定一个成为单例
 */
public class TestSingleton1 {

    public static  void main (String[] args){
        Singleton1 singleton1=Singleton1.INSTANCE;
        System.out.println(singleton1);

        TestSingleton singleton=TestSingleton.instance;
        System.out.println(singleton);

    }
}
