package com.kaysanshi.apache_commons.collecions;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collection4Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        CollectionUtils.addAll(list,"1");
        // 如果为空返回emptyList [] 否则返回list
        Collection<String> strings = CollectionUtils.emptyIfNull(list);
        System.out.println(strings.toString());
        // 添加元素，如果元素部位null则进行添加
        CollectionUtils.addIgnoreNull(list,null);
        CollectionUtils.addIgnoreNull(list,"2");
        System.out.println(list.toString());


        List<String> stringList = new ArrayList<>();
        CollectionUtils.addAll(stringList, "张三","李四");
        if (CollectionUtils.isEmpty(stringList)) {
            System.out.println(stringList.size());
        }
        // 判断是否为空
        System.out.println(CollectionUtils.isEmpty(stringList));
        // 判断不为空
        System.out.println(CollectionUtils.isNotEmpty(stringList));

        // 获取交集
        List<String> stringList1 = new ArrayList<>();
        CollectionUtils.addAll(stringList1, "张三","李四","王二","赵尔");
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
        CollectionUtils.addAll(stringList2, "张三","李四");
        boolean equalCollection = CollectionUtils.isEqualCollection(stringList, stringList2);
        System.out.println(equalCollection);

    }
}
