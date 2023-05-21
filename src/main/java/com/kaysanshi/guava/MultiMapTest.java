package com.kaysanshi.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * 一个key多个value值
 * 多重映射接口扩展映射，使得其键一次可被映射到多个值。
 */
public class MultiMapTest {
    public static void main(String args[]){
        MultiMapTest tester = new MultiMapTest();
        Multimap<String,String> multimap = tester.getMultimap();

        List<String> lowerList = (List<String>)multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowerList.toString()); //  [a, b, c, d, e]
        lowerList.add("f");
        System.out.println("Modified lower case list");
        System.out.println(lowerList.toString()); // [a, b, c, d, e, f]

        List<String> upperList = (List<String>)multimap.get("upper");
        System.out.println("Initial upper case list");
        System.out.println(upperList.toString());// [A, B, C, D]
        upperList.remove("D");
        System.out.println("Modified upper case list");
        System.out.println(upperList.toString()); // [A, B, C]

        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");
        for (Map.Entry<String,  Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value =  multimap.get("lower");
            System.out.println(key + ":" + value);
        }

        System.out.println("Keys of Multimap");
        Set<String> keys =  multimap.keySet();
        for(String key:keys){
            System.out.println(key);
        }

        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();
        System.out.println(values);


        Map<String,String> maps = new HashMap<>();
        maps.put("name","张三");
        maps.put("name",null);
        System.out.println(maps.values());
    }

    private Multimap<String,String> getMultimap(){
        //Map<String, List<String>>
        // lower -> a, b, c, d, e
        // upper -> A, B, C, D

        Multimap<String,String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");
        return multimap;
    }

}
