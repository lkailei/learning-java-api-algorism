package com.kaysanshi.apache_commons.collecions;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CollectionUtilsTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        CollectionUtils.addAll(stringList, new String[]{"张三","李四"});
        if (CollectionUtils.isEmpty(stringList)) {
            System.out.println(stringList.size());
        }
        // 判断是否为空
        System.out.println(CollectionUtils.isEmpty(stringList));
        // 判断不为空
        System.out.println(CollectionUtils.isNotEmpty(stringList));

        // 获取交集
        List<String> stringList1 = new ArrayList<>();
        CollectionUtils.addAll(stringList1, new String[]{"张三","李四","王二","赵尔"});
        CollectionUtils.intersection(stringList, stringList1);

        // 并集
        Collection union = CollectionUtils.union(stringList1, stringList);
        System.out.println(union.size());
        union.forEach(System.out::println);
        // 交集的补集
        Collection disjunction = CollectionUtils.disjunction(stringList, stringList1);
        disjunction.forEach(System.out::println);
        // 差集
        Collection subtract = CollectionUtils.subtract(stringList, stringList1);
        subtract.forEach(System.out::println);

        // 判断集合是否相等
        List<String> stringList2 = new ArrayList<>();
        CollectionUtils.addAll(stringList2, new String[]{"张三","李四"});
        boolean equalCollection = CollectionUtils.isEqualCollection(stringList, stringList2);
        System.out.println(equalCollection);

        // 创建不可修改的集合
        // Collections.unmodifiableCollection可以得到一个集合的镜像，它的返回结果是不可直接被改变，否则会提示错误
        List<String> unModifiedList = new ArrayList<>();
        Collection collection = CollectionUtils.unmodifiableCollection(unModifiedList);
        unModifiedList.add("aaa");
        System.out.println(collection);
    }
}
