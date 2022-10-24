package com.kaysanshi.design_pattern.singleton;

/**
 * user:kay三石
 * time: 10:38
 * desc: 饿汉式单例模式：
 *  关键点：私有的构造方法，只提供一个暴露的接口，静态不可变的声明
 **/
public class HungryStaticSingleton {
    // 使用静态代码块的
    private static final HungryStaticSingleton hungrysingleton;

    static {
        hungrysingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){};

    public static HungryStaticSingleton getInstance(){
        return hungrysingleton;
    }




}
