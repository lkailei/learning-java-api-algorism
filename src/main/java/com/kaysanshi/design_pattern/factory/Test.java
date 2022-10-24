package com.kaysanshi.design_pattern.factory;

/**
 * user:kay三石
 * time: 22:20
 * desc: 工厂方法模式使用场景：
 * 创建对象需要大量的重复的代码
 * 客户端不依赖于产品类实例如何被创建，如何被实现等细节
 * 一个类通过其子类来指定创建哪个对象。
 * 复杂度，理解难度变高
 **/
public class Test {

    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse iCourse = factory.create();
        iCourse.record();

        factory = new PythonCourseFactory();
        iCourse = factory.create();
        iCourse.record();
        /**
         * ~output
         * 录制java视频
         * 录制python课程
         */
    }
}
