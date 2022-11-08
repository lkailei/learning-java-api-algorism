package com.kaysanshi.apache_commons.lang3;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils 常用的工具类操作
 */
public class TestStringUtils {

    /**
     * 测试字符串字符串是否相等(包含大小写)
     *
     * @return
     */
    public static void compareIgnoreCase(String a,String b) {
        System.out.println(StringUtils.compareIgnoreCase(a, b));
    }

    /**
     * 测试是否包含某个字符串 A中是否包含B
     * @param a
     * @param b
     */
    public static void contain(String a,String b) {
        System.out.println(StringUtils.contains(a, b));
    }



    public static void main(String[] args) {
        TestStringUtils.compareIgnoreCase("a","A");
        TestStringUtils.compareIgnoreCase("a",null);
        TestStringUtils.contain("a",null);
        TestStringUtils.contain("a","a");
        // 判断是府空白，包含null 空串，空格
        StringUtils.isBlank(null); // true
        StringUtils.isBlank(""); // true
        StringUtils.isBlank(" "); // true
        // 判断是否为空，包含null空串
        StringUtils.isEmpty(null); // true
        StringUtils.isEmpty(""); // true
        StringUtils.isEmpty(" "); // false

        // 如果字符串未出现指定的后缀，则追加后缀，否则返回原字符串
        StringUtils.appendIfMissing("abc","def"); // abcdef
        StringUtils.appendIfMissing("abcddef","def"); // abcddef
        // abbreviate 字符串缩略该方法可以实现字符串的省略，设置字符长度，后面三个字符显示为 " ... " (如果字符串长度比设置的小，就不会显示了)
        StringUtils.abbreviate("abdcd",2);// ab...s

        // 字符串忽略大小写比较
        StringUtils.compare("QAB",null);// 1
        StringUtils.compare("QAB","qab");// 0
        StringUtils.compareIgnoreCase("QBA","QBA");// 0
        // 删除空格
        StringUtils.deleteWhitespace(" addd add");;// adddadd
        // 字符串以什么字符结束
        StringUtils.endsWith("Adbc","c");// true

        // 以某个字符进行分割
        StringUtils.split("123,5,6,7",","); // ["123","5","6","7"]
        StringUtils.split("abc:bcd:efg",":");// ["abc","bcd","efg]

        // 字符串A查找b替换b为c
        StringUtils.replace("hello word","word","abc");//"hello abc"

        // 将字符串的首字母转换成大写，这个函数的神奇之处在于可以转换一些特殊字符，比如dz，看起来是2个字符，其实却是一个
        StringUtils.capitalize("dz");// Dz;

        // 在字符串两边填充空格，并返回带空格的新字符串，新字符串长度等于size参数的长度
        StringUtils.center("bcd",5);// " bcd "; 左右各一个空格

        //  在字符串左侧填充空格满足到指定的长度
        StringUtils.leftPad("abc",5); // "  abc"
        // 在字符串左侧填充指定的字符满足到指定的长度
        StringUtils.leftPad("abc",5,"-"); // "--abc"

        //  在字符串右侧填充空格满足到指定的长度
        StringUtils.rightPad("abc",5); // "abc  "
        // 在字符串右侧填充指定的字符满足到指定的长度
        StringUtils.rightPad("abc",5,"-");// "abc--"

        // 切除字符串最后面的子字符串
        StringUtils.chomp("abc123","123");// "abc"

        // 主字符串是否包含子字符串中任意的字符
        StringUtils.containsAny("abc","ab");// = true
        StringUtils.containsAny("abc","ac");// = true
        StringUtils.containsAny("abc","ae");// = true
        StringUtils.containsAny("abc","de");// = false

        // 主字符串是否不包含子字符串中任意字符
        StringUtils.containsNone("abc","cd");// = false，因为存在c
        StringUtils.containsNone("abc","de") ;//= true

        // 检测字符串中是否包含空白，包含回车和换行等空白符号
        StringUtils.containsWhitespace("abc de"); // true
        StringUtils.containsWhitespace("abc\nde"); // true
        StringUtils.containsWhitespace("abc\rde"); // true
        StringUtils.containsWhitespace("abcde"); // false

        // 子串在主串中出现的次数
        StringUtils.countMatches("aabbcc","c");// 2
        StringUtils.countMatches("aabbcc","cc");// 1

        // defaultIfBlank(a,b) 如果字符串为空白，则用一个默认字符串代替
        StringUtils.defaultIfBlank(null,"123");// 123
        StringUtils.defaultIfBlank("","123");// 123
        StringUtils.defaultIfBlank(" ","123");// 123

        // 如果字符串为空，则用默认字符串代替
        StringUtils.defaultIfEmpty(null,"123");//123
        StringUtils.defaultIfEmpty("","123");//123

        // 提取字符串中数值部分
        StringUtils.getDigits("abcdedd12345");//12345


        // lastIndexOf 搜索的字符串最后一次在被搜索字符串中出现的位置
        StringUtils.lastIndexOf("abcdd","d");// 4


    }



}
