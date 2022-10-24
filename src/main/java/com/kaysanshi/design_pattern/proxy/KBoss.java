package com.kaysanshi.design_pattern.proxy;

import java.lang.reflect.Method;

/**
 * KBoss是移动代理点的，
 */
public class KBoss implements KInVocationHandler {
    // 被代理的对象
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;

    }

    private void after() {
        System.out.println("缴纳完毕，等待移动返回数据");
    }

    private void before() {
        System.out.println("我是中国移动代理商现在为你缴纳花费");
        System.out.println("开始缴纳");
    }

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return KProxy.newProxyInstance(new KClassLoader(), clazz.getInterfaces(), this);
    }
}

