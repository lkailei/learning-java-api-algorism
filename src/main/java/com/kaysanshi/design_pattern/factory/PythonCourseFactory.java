package com.kaysanshi.design_pattern.factory;

/**
 * user:kay三石
 * time: 22:18
 * desc:
 **/
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
