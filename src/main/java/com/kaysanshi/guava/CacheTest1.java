package com.kaysanshi.guava;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * cache loader方式实现
 */
public class CacheTest1 {
    public static void main(String[] args) {
        // CacheLoader 初始化
        CacheLoader<String, Object> cacheLoader = new CacheLoader<String, Object>() {
            @Override
            // load方法的作用是在通过get方法从LoadingCache获取不到值时去加载该值并放入缓存。
            public String load(String key) throws Exception {
                // 模拟加载值的过程
                Thread.sleep(1000);
                // 假设某个key是非法访问的
                if ("err".equals(key)) {
                    return null;
                }
                return key + "'s value";
            }
        };

        // 移出监听器配置
        RemovalListener<String, Object> removalListener = new RemovalListener<String, Object>() {
            // 移出时触发的事件
            public void onRemoval(RemovalNotification<String, Object> removal) {
                System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] is evicted!");
            }
        };

        // 创建LoadingCache 主要缓存对象
        LoadingCache<String, Object> caches = CacheBuilder.newBuilder()
                // 设置容量大小
                .maximumSize(5)
                // 设置超时时间
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                // 移出监听器
                .removalListener(removalListener)
                // 加载器配置
                .build(cacheLoader);

        // 由于缓存的容易只设置了5个，存入10个就会由guava基于容量回收掉5个
        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "value" + i;
            caches.put(key, value);
            System.out.println("[" + key + ":" + value + "] is put into cache!");
        }

        // 如果存在就获取
        System.out.println(caches.getIfPresent("key6"));

        try {
            caches.get("err");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("不存在key，会报错");
        }
    }
}
