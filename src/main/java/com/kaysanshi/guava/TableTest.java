package com.kaysanshi.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTest {
    public static void main(String[] args) {
        //创建row,column,value结构的table
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("a1","c1",23);
        table.put("a1","c2",77);
        table.put("a2","c2",44);
        //通过rowKey获取columnKey->value的映射关系
        System.out.println(table.row("a1")); // {c1=23, c2=77}
        //通过columnKey获取rowKey ->value的映射关系
        System.out.println(table.column("c2")); // {a1=77, a2=44}
    }
}
