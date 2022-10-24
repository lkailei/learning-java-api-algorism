package com.kaysanshi.design_pattern.proxy;

import java.lang.reflect.Method;

/**
 * 创建一个KInVocationHandler的接口
 */
public interface KInVocationHandler {
     Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
