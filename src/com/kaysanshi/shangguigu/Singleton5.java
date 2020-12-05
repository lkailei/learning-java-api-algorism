package com.kaysanshi.shangguigu;

/**
 * @Author kay三石
 * @date:2019/6/2
 *
 */
public class Singleton5 {

    private Singleton5(){

    }
    //静态内部类不会随着外部类的创建二初始化，只鞥够通过自己去实例化
    private static class Inner{
        private static final Singleton5 INSTANCE=new Singleton5();

    }
    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }
}
