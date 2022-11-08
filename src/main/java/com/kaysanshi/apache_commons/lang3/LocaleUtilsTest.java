package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.LocaleUtils;

/**
 * 获取当前有效的地区集合
 */
public class LocaleUtilsTest {
    public static void main(String[] args) {
        System.out.println(LocaleUtils.availableLocaleList());
        System.out.println(LocaleUtils.toLocale("zh"));
    }
}
