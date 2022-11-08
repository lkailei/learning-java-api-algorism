package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsTest {
    public static void main(String[] args) {
        int[] array= {0,3,4};
        int[] add = ArrayUtils.add(array, 3);
        boolean contains = ArrayUtils.contains(array, 2); //false
        int[] ints = ArrayUtils.addFirst(array, -1);// [-1,0,3,4]
        // 找到元素所在的索引，未找到返回-1
        int i = ArrayUtils.indexOf(array, 3);// 1

    }
}
