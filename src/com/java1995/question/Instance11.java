package com.java1995.question;

import java.util.ArrayList;
import java.util.List;

//写一个函数,输出所有的子串
public class Instance11 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "ABCd";// 原字符串
        List <String> result = list(s, "");// 列出字符的组合，放入result
        System.out.println(result.size());
        System.out.println(result);
    }

    /**
     * 列出基础字符串(base)的所有组合
     *
     * @param base   以该字符串作为基础字符串，进行选择性组合。
     * @param buff   所求字符串的临时结果
     * @param result 存放所求结果
     */
    public static List <String> list(String base, String buff) {
        List <String> result = new ArrayList <String>();// 存放结果信息。
        if (base.length() <= 0) {
            result.add(buff);
        }
        for (int i = 0; i < base.length(); i++) {
            List <String> temp = list(new StringBuilder(base).deleteCharAt(i)
                    .toString(), buff + base.charAt(i));
            result.addAll(temp);

        }
        return result;
    }

    /**
     * 列出基础字符串(base)的所有组合
     *
     * @param base   以该字符串作为基础字符串，进行选择性组合。
     * @param buff   所求字符串的临时结果
     * @param result 存放所求结果
     */
    public static void list(String base, String buff, List <String> result) {
        if (base.length() <= 0) {
            result.add(buff);
        }
        for (int i = 0; i < base.length(); i++) {
            list(new StringBuilder(base).deleteCharAt(i).toString(), buff
                    + base.charAt(i), result);
        }
    }
}
