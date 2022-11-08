package com.kaysanshi.apache_commons.collecions;

import org.apache.commons.collections4.SetUtils;

import java.util.HashSet;
import java.util.Set;

public class SetUtilsTest {
    public static void main(String[] args) {
        Set<Integer> set1= new HashSet<>();
        set1.add(2);
        set1.add(3);
        set1.add(4);
        HashSet<Integer> set = SetUtils.hashSet(1, 2, 3, 4, 5, 6);
        // 两个set中不一致的
        Set<Integer> integers = SetUtils.difference(set, set1).toSet();
        System.out.println(integers.toString()); // [1,5,6]

        boolean equalSet = SetUtils.isEqualSet(set1, set); // false

        //交集的补集
        System.out.println(SetUtils.disjunction(set,set1).toString()); // 1.5.6

        // 交集
        System.out.println(SetUtils.intersection(set,set1).toString()); // 2,3,4

        // 并集
        System.out.println(SetUtils.union(set,set1));// [1, 2, 3, 4, 5, 6]



    }
}
