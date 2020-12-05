package com.jzoffer;

/**
 * @Author kay三石
 * @date:2019/6/10
 * 请实现一个函数用来判断字符串是否表示数值(包括整数和小数)表示数值的字符串
 * "+100" "5e2" "-1E-16" true
 * "12e" "1a3.14" "1.2.3" "+-5" false
 * 解题思路：根据正则表达式判断
 * [] :字符集合
 * ()：字符集合
 * ?:重复0-1
 * +：重复1-n
 * *:重复0-n
 * .:任意字符
 * \:转义后的
 * \d：数字
 */
public class StringTest1 {

    public boolean isNumeric(char[] str){
        if (str==null||str.length==0){return false;}
        return new String(str).matches("");
    }
}
