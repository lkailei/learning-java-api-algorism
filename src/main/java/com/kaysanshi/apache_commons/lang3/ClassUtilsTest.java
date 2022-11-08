package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtilsTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = ClassUtils.getClass("java.lang.String");
        String name = ClassUtils.getName(String.class); // java.lang.String
        String packageName = ClassUtils.getPackageName(System.class); // 包名 java.lang
        System.out.println(ClassUtils.getShortClassName(System.class));//返回 System
        System.out.println(ClassUtils.getName(System.class));//返回 java.lang.System
        System.out.println(ClassUtils.getPackageName(System.class));//返回 包名
        System.out.println(ClassUtils.getShortCanonicalName(System.class));//返回 System
        System.out.println(ClassUtils.getSimpleName(System.class));//返回 System
        // 获取所有的属性
        Field[] allFields = FieldUtils.getAllFields(aClass);
        // 获取所有的方法
        Method accessibleMethod = MethodUtils.getAccessibleMethod(System.class.getEnclosingMethod());

    }
}
