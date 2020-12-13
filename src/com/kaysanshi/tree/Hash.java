package com.kaysanshi.tree;

import java.math.BigInteger;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * hash表：底层是数组来实现的
 *
 * @author leoill
 * @date 2019年5月5日
 */
public class Hash {
    private Info[] arry;


    public Hash() {
        arry = new Info[100];
    }

    /**
     * 指定数组的大小
     */
    public Hash(Integer maxSize) {
        arry = new Info[maxSize];
    }

    /**
     * 插入数据
     *
     * @param info
     */
    public void insert(Info info) {
        arry[info.getKey()] = info;
        //获取关键字
        //关键字所对应的hash数
    }

    /**
     * 查找数据
     */
    public Info find(int key) {
        return arry[key];
    }

    /**
     * 如果索引为下String类型的要进行转换为哈希code
     * 通过对字母的Ascll码的累加算出的但是有很大的重复，比如：abc bbb cba他们的hash编码都是相同的
     */
    public int hashCode(String key) {
        int hashVal = 0;
        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;//A:97所以一直减去
            hashVal += letter;
        }
        return hashVal;
    }

    /**
     * 通过幂的连乘解决以上的问题:
     * 这里需要对数组的初始化值加大从而让其不产生越界
     */
    public int Hashcode(String keyy) {
        int hashValue = 0;
        int pow27 = 1;
        for (int i = keyy.length() - 1; i >= 0; i--) {
            int letter = keyy.charAt(i) - 96;
            hashValue += letter * pow27;
            pow27 *= 27;
        }
        return hashValue;

    }

    /**
     * 使用压缩空间使得不越界,要使用Biginteger类型来操作
     * 有可能会重，不一定都能映射到空白的地址中
     */
    public int hashcode(String keyyy) {
        BigInteger hashValue = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        //  int pow27=1
        for (int i = keyyy.length() - 1; i >= 0; i--) {
            int letter = keyyy.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashValue = hashValue.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashValue.mod(new BigInteger(String.valueOf(arry.length))).intValue();

    }
    /**
     * 查找的时直接用：arry[hashCode(key)]=info
     *
     *
     */
    /////////////////////////////////
    ////
    ////以下用开放地址法进行使用：
    ////
    ////
    ////
    /////
    /////////////////////////////////

    /**
     * 以上都会产生冲突
     * 所以使用开放地址法：
     * 当产生冲突党的时候，通过查找数组的一个空位，并将数据填入，而不再用hash函数得到的数组下标
     */
    public void insertBy(Info info) {
        //获得关键字
        String key = info.getKey1();
        //关键字所定义的自定义的hash数
        int hascode = hashcode(key);
        while (arry[hascode] != null && arry[hascode].getValue() != null) {
            //进行递加
            ++hascode;
            //循环
            hascode %= arry.length;

        }
        arry[hascode] = info;
    }
    /////////////////////////////
    ///
    ///以下是用链地址法：
    ///：在哈希表中每个单元中设置链表，某个数据项的关键字还是像通常一样，映射到hash表中的单元中，而数据项本身，插入到单元中的链表中
    ///
    ///
    ///
    /////////////////////////////


    /**
     * 查找
     *
     * @param key
     * @return
     */
    public Info findByy(String key) {
        int hashVal = hashcode(key);
        while (arry[hashVal] != null) {
            if (arry[hashVal].getKey1().equals(key)) {
                return arry[hashVal];
            }
            ++hashVal;
            hashVal %= arry.length;
        }
        return null;
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    public Info delete(String key) {
        int hashVal = hashcode(key);
        while (arry[hashVal] != null) {
            if (arry[hashVal].getKey1().equals(key)) {
                Info temp = arry[hashVal];
                temp.setValue(null);
                return temp;

            }
            ++hashVal;
            hashVal %= arry.length;
        }

        return null;

    }

}

class Info {

    private Integer key;

    private String key1;

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    private String value;

    public Info(Integer key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public Info(String key1, String value) {
        super();
        this.key1 = key1;
        this.value = value;
    }

    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}