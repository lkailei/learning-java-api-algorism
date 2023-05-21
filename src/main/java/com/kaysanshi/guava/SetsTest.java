package com.kaysanshi.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

public class SetsTest {
    public static void main(String[] args) {
        HashSet<String> set = Sets.newHashSet();
        LinkedHashSet<Object> hashSet = Sets.newLinkedHashSet();
        HashSet<Object> objects = Sets.newHashSetWithExpectedSize(10);
        TreeSet<Comparable> comparables = Sets.newTreeSet();
        Set<Object> objects1 = Sets.newConcurrentHashSet();
        SetsTest setsTest = new SetsTest();
        setsTest.cartesianProduct();
    }

    /**
     *
     */
    public void cartesianProduct(){
        Set<String> set1 = Sets.newHashSet("a","b","c");
        Set<String> set2 = Sets.newHashSet("1","2","3");
        Set<String> set3 = Sets.newHashSet("@","2","&");
        //多个Set的笛卡尔集，参数接收多个set集合
        Set<List<String>> sets = Sets.cartesianProduct(set1,set2,set3);
        System.out.println(sets);

        List<Set<String>> list = Lists.newArrayList(set1,set2,set3);
        //也可以把多个Set集合，放到一个list中，再计算笛卡尔集
        Set<List<String>> sets1 = Sets.cartesianProduct(list);
        System.out.println(sets1);
        // 按指定大小进行排列组合
        Set<Set<String>> combinations = Sets.combinations(set1, 2);
        System.out.println(combinations); //Sets.combinations([a, b, c], 2)
        // 两个集合的差集
        System.out.println(Sets.difference(set1,set2));// [a, b, c]
        System.out.println(Sets.difference(set2,set1));// [1, 2, 3]
        // 在后者中没有的前者列出来 差集
        System.out.println(Sets.difference(set2,set3));// [1, 3]
        // 交集
        System.out.println(Sets.intersection(set1,set2));// []
        System.out.println(Sets.intersection(set2,set3));// [2]
        // 并集
        System.out.println(Sets.union(set2,set3));// [1, 2, 3, @, &]
    }
}
