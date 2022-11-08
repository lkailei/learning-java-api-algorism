package com.kaysanshi.apache_commons.collecions;

import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtilsTest {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);

        List<Integer> listB = new ArrayList<>();
        listB.add(2);
        listB.add(3);
        listB.add(4);

        long start = System.currentTimeMillis();
        List<Integer> sub1 = ListUtils.subtract(listA, listB); // list1与list2的差集
        List<Integer> sub2 = ListUtils.subtract(listB, listA); // list2与list1的差集
        List<Integer> union = ListUtils.union(sub1, sub2); // sub1与sub2的并集
        long diff = System.currentTimeMillis() - start;
        System.out.println("sub1:"+sub1.toString());// sub1:[1]
        System.out.println("sub2:"+sub2.toString());// sub2:[4]
        System.out.println("union:"+union.toString());
        System.out.println("diff:"+diff);
        // 两个list是否相等
        System.out.println(ListUtils.isEqualList(sub1,sub2));
        // 取并集 无重复项的并集
        System.out.println(ListUtils.sum(listA,listB));
    }
}
