package com.kaysanshi.design_pattern.singleton;

/**
 * user:kay三石
 * time: 10:49
 * desc:在类加载时就创建，不适用静态代码块
 **/
public class HungrySingleton {
    private static final  HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){};

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
