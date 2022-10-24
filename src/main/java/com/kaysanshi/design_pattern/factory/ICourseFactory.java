package com.kaysanshi.design_pattern.factory;

/**
 * user:kay三石
 * time: 22:01
 * desc:简单工厂方法模式：指的是定义一个创建对象的接口,但让这个接口的实现类来决定实例化哪个类，工厂方法模式让类的实例话推迟到子类中进行。
 * 在工厂方法中用户只需关注所需产品对应的工厂，无需关心创建细节，而且符合科开闭原则
 *
 **/
public interface ICourseFactory {
    ICourse create();
}
