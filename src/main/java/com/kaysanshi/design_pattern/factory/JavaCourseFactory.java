package com.kaysanshi.design_pattern.factory;

/**
 * user:kay三石
 * time: 22:17
 * desc:
 **/
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
