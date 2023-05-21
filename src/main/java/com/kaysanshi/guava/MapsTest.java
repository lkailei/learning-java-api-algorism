package com.kaysanshi.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.kaysanshi.apache_commons.beanUtils.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapsTest {
    public static void main(String[] args) {
        MapsTest test = new MapsTest();
        test.setToMap();
        test.difference();
        test.filterEntries();
        test.filterKeys();
        test.filterValues();
        test.transFormEntries();
        test.transformValues();

        test.uniqueIndex();
    }

    public void createDemo() {
        Maps.newHashMap();
        Maps.newHashMapWithExpectedSize(10);
        //Maps.newEnumMap();
        Maps.newConcurrentMap();
        Maps.newIdentityHashMap();

        Maps.newLinkedHashMap();
        Maps.newLinkedHashMapWithExpectedSize(10);

        Maps.newTreeMap();
    }

    /**
     * set TOMap
     */
    public void setToMap() {
        Set<String> set = Sets.newHashSet("a", "b", "c");
        //将set转成Map,key为set元素,value为每个元素的长度
        Map<String, Integer> map = Maps.asMap(set, String::length);
        System.out.println(map);//     {a=1, b=1, c=1}}
    }

    /**
     * 计算map的差值
     */
    public void difference(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","1");
        map2.put("e","5");
        map2.put("f","6");
        //mapDifference是将两个map相同的部分剔除
        MapDifference<String,String> mapDifference = Maps.difference(map1,map2);
        //两个Map相同的部分
        System.out.println(mapDifference.entriesInCommon()); //  {a=1}
        //左边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnLeft()); // {b=2, c=3}
        //右边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnRight());// {e=5, f=6}
    }


    /**
     * 通过Entry过滤
     */
    public void filterEntries(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterEntries(map1,item -> !item.getValue().equalsIgnoreCase("2"));
        System.out.println(result);// {a=1, c=3}

    }

    /**
     * 通过key过滤
     */
    public void filterKeys(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.filterKeys(map1, item -> !item.equalsIgnoreCase("b"));
        System.out.println(result);// {a=1, c=3}
    }

    /**
     * 过滤value
     */
    public void filterValues(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result =  Maps.filterValues(map1,item -> !item.equalsIgnoreCase("3"));
        System.out.println(result);// {a=1, b=2}
    }

    /**
     * 转换entry
     */
    public void transFormEntries(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformEntries(map1,(k,v) -> k + v);
        System.out.println(result);// {a=a1, b=b2, c=c3}
    }

    /**
     * 转换value
     */
    public void transformValues(){
        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> result = Maps.transformValues(map1, value -> value + 10);
        System.out.println(result); // {a=110, b=210, c=310}
    }

    /**
     * uniqueINdex 根据key生成map要确保key值唯一
     */
    public void uniqueIndex(){
        List<Animal> animals = new ArrayList<>();
        ImmutableMap<Integer, Animal> integerAnimalImmutableMap = Maps.uniqueIndex(animals, Animal::getId);
        System.out.println(integerAnimalImmutableMap.entrySet());// []
    }



}
class Animal{
    private Integer id ;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

