package com.kaysanshi.design_pattern.singleton;

/**
 * user:kay三石
 * time: 10:41
 * desc: 懒汉式单例模式，就是什么时候用什么时候进行构造
 * 如果有了就直接返回,有线程安全问题
 **/
public class LazySingleton {
    // 静态的
    private static  LazySingleton lazySingleton = null;

    private LazySingleton(){};

    public static  LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
