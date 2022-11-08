package com.kaysanshi.apache_commons.collecions;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("忘忧草","2000");
        map.put("忘忧草2","20400");
        map.put("忘忧草3","20000");
        map.put("忘忧草4","20300");
        map.put("忘忧草5","20100");
        System.out.println(MapUtils.isEmpty(map)); // false
        System.out.println(MapUtils.isNotEmpty(map)); // true
        // MapUtils.getXXX(map,key); 获取map中对应key的值的类型。如果有返回值，否则返回false
        System.out.println(MapUtils.getString(map,"忘忧草")); // 有值直接返回未找到key返回false
        System.out.println(MapUtils.getBoolean(map,"忘忧草")); // false
        // map转为线程安全的map
        Map map1 = MapUtils.synchronizedMap(map);

    }
}
