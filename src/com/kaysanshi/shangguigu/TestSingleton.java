package com.kaysanshi.shangguigu;

/**
 * @Author kay三石
 * @date:2019/6/2
 * 写一个单例设计模式：
 * 单例设计模式：指在整个系统中只能有一个实例对象可获取和使用的代码模式
 * 一个类只能有一个实例：构造器私有化
 * 必须自行创建这个实例：含有一个该类的静态变量来保存唯一的实例
 * 必须自行向整个系统中提供这个实例：对外提供获取该例实例对象方式
 * 饿汉式：直接创建实例对象，不管你是否需要这个对象
 * 1.构造器私有化
 * 2.自行创建并且用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是个单路可以用final修饰
 */
public class TestSingleton {

    public static final TestSingleton instance=new TestSingleton();
    private TestSingleton(){

    }
}
