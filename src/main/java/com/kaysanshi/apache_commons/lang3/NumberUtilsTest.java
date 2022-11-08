package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class NumberUtilsTest {
    public static void main(String[] args) {

        // 创建指定对象
        // NumberUtils.createXXX()
        BigDecimal bigDecimal = NumberUtils.createBigDecimal("12334");
        BigInteger bigInteger = NumberUtils.createBigInteger("1233");
        Double aDouble = NumberUtils.createDouble("123.0");
        Integer integer = NumberUtils.createInteger("123");
        Long aLong = NumberUtils.createLong("12333");
        Number number = NumberUtils.createNumber("12");
        Float aFloat = NumberUtils.createFloat("123.00");
        // 判断操作
        // 检查给定字符串是否是否只包含数字字符
        boolean digits = NumberUtils.isDigits("123.0"); // true
        ////检查给定字符串是否是可解析的数字
        boolean parsable = NumberUtils.isParsable("122"); // true
        // 检查字符串是否是有效的Java数字
        ////isCreatable 慎用，有效数字包括进制标有0x或0X预选项，八进制数、科学记数法和标有类型限定符的数字
        ////所以08，09返回false，不是有效的八进制
        NumberUtils.isCreatable("abc"); //false

        // 转换功能
        // NumberUtils.toXXX("123",x); 失败返回参数2
        byte b = NumberUtils.toByte("123");
        int i = NumberUtils.toInt("123");
        double v = NumberUtils.toDouble("123");
        //将一个字符串转换为BigDecimal,默认保留2位小数,舍入模式为RoundingMode.HALF_EVEN
        BigDecimal bigDecimal1 = NumberUtils.toScaledBigDecimal("2.1");
        //将一个字符串转换为BigDecimal,自定义小数位数,自定义舍入模式
        NumberUtils.toScaledBigDecimal("2.1", 2, RoundingMode.HALF_UP);

        // 比较计算
        int[] array={4,5,3,5,2};
        int max = NumberUtils.max(array);// 5
    }
}
