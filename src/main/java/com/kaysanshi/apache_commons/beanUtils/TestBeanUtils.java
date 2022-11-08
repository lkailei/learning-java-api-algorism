package com.kaysanshi.apache_commons.beanUtils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * <dependency>
*             <groupId>commons-beanutils</groupId>
*             <artifactId>commons-beanutils</artifactId>
*             <version>1.9.3</version>
*         </dependency>
 */
public class TestBeanUtils {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 必须是平常的类。不可以是内部类
        Student student = new Student();
        student.setId(1);
        student.setName("zhangsan");
        System.out.println(student.toString()); // Student{id=1, name='zhangsan', clazzId=null, clazzName='null'}
        Student student1 = new Student();
        // copyProperties 底层实际调用： BeanUtilsBean.getInstance().copyProperties(dest, orig);
        BeanUtils.copyProperties(student1,student);
        System.out.println(student1.toString()); // Student{id=1, name='zhangsan', clazzId=null, clazzName='null'}
        // copy 的时候设置属性名字
        BeanUtils.copyProperty(student1,"name","zz");
        System.out.println(student1.toString()); // Student{id=1, name='zz', clazzId=null, clazzName='null'}

    }
}
