package com.kaysanshi.design_pattern.singleton;

/**
 * user:kay三石
 * time: 11:35
 * desc: 这种形式兼顾饿汉式单例模式的内存浪费问题和synchronized的性能问题
 **/
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){};

    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY=new LazyInnerClassSingleton();
    }
}

