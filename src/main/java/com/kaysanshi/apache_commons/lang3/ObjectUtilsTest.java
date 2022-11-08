package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtilsTest {
    public static void main(String[] args) {

        // allNotNull(Object... values) 检查素养的元素是否为空，返回boolean

        ObjectUtils.allNotNull(null,","); // false

        // anyNotNull() 检查元素一个为空则返回true

        ObjectUtils.anyNotNull(null); //false
        // 对像clone
        String abc=new String("123");
        String clone = ObjectUtils.clone(abc);
        // 如果对象为空返回一个默认值，这里默认值为参数2
        ObjectUtils.defaultIfNull("1","2");
        ObjectUtils.isEmpty("12"); // false

        // 比较两个对象
        ObjectUtils.compare("12","12");

    }

}
