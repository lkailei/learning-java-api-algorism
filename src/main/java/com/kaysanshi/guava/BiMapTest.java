package com.kaysanshi.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 它是一种特殊的Map，可以实现键值的反转
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("a","123");
        System.out.println(biMap); // {a=123}
        //对键值对进行反转
        System.out.println(biMap.inverse()); // {123=a}

        //试图将一个key映射到已经存在的值上，会抛异常 value already present: 123
        //biMap.put("b","123");

        //强值将一个key映射到已经存在的值上，会将原来的key覆盖掉
        biMap.forcePut("b","123");
        System.out.println(biMap);// {b=123}
    }
}
