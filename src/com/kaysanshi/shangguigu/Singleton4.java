package com.kaysanshi.shangguigu;

/**
 * @Author kay三石
 * @date:2019/6/2
 * 懒汉式：
 * 延迟创建这个实例化对象
 * 1.构造器私有化
 * 2.用一个静态变量保存唯一的实例
 * 3.提供一个静态方法获取实例对象
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){

    }
    //只有这里使用调用这个方法时才会创建,
    public static Singleton4 getInstance(){
        //这样写单线程时么问题，但是并发时会出现问题。
        //if (instance==null){
      //      instance=new Singleton4();
       // }
       //return  instance;
        if (instance==null){
        synchronized (Singleton4.class){
            if (instance==null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance=new Singleton4();
            }

            }
        }
        return  instance;
    }
}
