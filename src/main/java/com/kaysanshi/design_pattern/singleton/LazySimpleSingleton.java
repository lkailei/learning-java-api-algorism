package com.kaysanshi.design_pattern.singleton;

/**
 * user:kay三石
 * time: 10:53
 * desc: 线程安全的懒汉式单例模式，但是会在线程比较多时加锁比较严重。两个线程调用，其中一个线程必将阻塞
 **/
public class LazySimpleSingleton {
    // 静态的
    private static  LazySimpleSingleton lazySingleton = null;

    private LazySimpleSingleton(){};

    public synchronized  static  LazySimpleSingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySimpleSingleton();
        }
        return lazySingleton;
    }
}
