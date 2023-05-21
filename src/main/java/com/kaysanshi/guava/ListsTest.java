package com.kaysanshi.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListsTest {
    public static void main(String[] args) {
        //将数组转成list,并在开头位置插入元素
        List<String> list = Lists.asList("a",new String[]{"b","c","d"});
        List<String> list1 = Lists.asList("a","b",new String[]{"c","d","e"});

        //直接创建ArrayList
        ArrayList<String> arrayList = Lists.newArrayList();
        //创建ArrayList,并初始化
        ArrayList<String> arrayList1 = Lists.newArrayList("a","b","c");
        //基于现有的arrayList,创建一个arrayList
        ArrayList<String> arrayList2 = Lists.newArrayList(arrayList1);
        //初始化指定容量大小的ArrayList，其中容量指ArrayList底层依赖的数组的length属性值，常用于提前知道ArrayList大小的情况的初始化
        ArrayList<String> arrayList3 = Lists.newArrayListWithCapacity(10);
        //初始化预定容量大小的ArrayList，返回的list的实际容量为5L + estimatedSize + (estimatedSize / 10)，常用于不确定ArrayList大小的情况的初始化
        ArrayList<String> arrayList4 =Lists.newArrayListWithExpectedSize(20);
        //创建CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
        //创建linkedList
        LinkedList<String> linkedList = Lists.newLinkedList();

        ListsTest test = new ListsTest();
        test.partition();
        test.cartesianProduct();
        test.charactersOf();
        test.reverse();
        test.transForm();
    }

    /**
     * 分割list
     */
    public void partition(){
        List<String> list = Lists.newArrayList("a","b","c","d","e");
        //将list按大小为2分隔成多个list
        List<List<String>> splitList = Lists.partition(list,2);
        System.out.println(splitList);// [[a, b], [c, d], [e]]
    }

    /**
     * 笛卡尔积
     */
    public void cartesianProduct(){
        List<String> list1 = Lists.newArrayList("a","b","c");
        List<String> list2 = Lists.newArrayList("d","e","f");
        List<String> list3 = Lists.newArrayList("1","2","3");
        //获取多个list的笛卡尔集
        List<List<String>> list = Lists.cartesianProduct(list1,list2,list3);
        System.out.println(list);// [[a, d, 1], [a, d, 2], [a, d, 3], [a, e, 1], [a, e, 2], [a, e, 3], [a, f, 1], [a, f, 2], [a, f, 3], [b, d, 1], [b, d, 2], [b, d, 3], [b, e, 1], [b, e, 2], [b, e, 3], [b, f, 1], [b, f, 2], [b, f, 3], [c, d, 1], [c, d, 2], [c, d, 3], [c, e, 1], [c, e, 2], [c, e, 3], [c, f, 1], [c, f, 2], [c, f, 3]]

    }

    /**
     * 将字符串转成字符集合
     */
    public void charactersOf(){
        //将字符串转成字符集合
        ImmutableList<Character> list = Lists.charactersOf("ababcdfb");
        System.out.println(list);// [a, b, a, b, c, d, f, b]
    }

    /**
     * 反转list
     */
    public void reverse(){
        List<String> list = Lists.newArrayList("a","b","c","1","2","3");
        //反转list
        List<String> reverseList = Lists.reverse(list);
        System.out.println(reverseList);// [3, 2, 1, c, b, a]
    }

    /**
     * 数据转换
     */
    public void transForm(){
        List<String> list = Lists.newArrayList("a","b","c");
        //把list中的每个元素拼接一个1
        List<String> list1 = Lists.transform(list,str -> str + "1");
        System.out.println(list1); //[a1, b1, c1]
    }


}
