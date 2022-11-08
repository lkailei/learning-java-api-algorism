package com.kaysanshi.apache_commons.beanUtils;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

public class TestBeanUtilsBean {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 必须是平常的类。不可以是内部类
        Student student = new Student();
        student.setId(1);
        student.setName("zhangsan");
        System.out.println(student.toString()); // Student{id=1, name='zhangsan', clazzId=null, clazzName='null'}
        Student student1 = new Student();
        BeanUtilsBean.getInstance().copyProperties(student1,student);
        System.out.println(student1.toString()); // Student{id=1, name='zhangsan', clazzId=null, clazzName='null'}
        // copy 的时候设置属性名字
        BeanUtilsBean.getInstance().copyProperty(student1,"name","zz");
        System.out.println(student1.toString()); // Student{id=1, name='zz', clazzId=null, clazzName='null'}
    }
}
