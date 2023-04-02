package com.kaysanshi.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * callable callback实现方式
 */
public class CacheTest2 {
    // 构建容量为3的缓存对象
    static Cache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(3)
            .build();

    public static void main(String[] args) {
        caches.put("zhangsan110", "key为名字+编号");

        // 如果存在就获取，不存在返回null
        System.out.println(caches.getIfPresent("zhangsan110"));

        try {
            // 获取key为zhangsan110的缓存数据，如果有就返回，没有就返回call方法的返回值
            System.out.println(caches.get("zhangsan110", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "没有获取到key执行";
                }
            }));

            // 获取key为110的缓存数据，如果有就返回，没有就返回call方法的返回值。
            System.out.println(caches.get("110", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "没有获取到key执行";
                }
            }));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    //key为名字+编号
    //key为名字+编号
    //没有获取到key执行

}
