package com.kaysanshi.data_structure.hash;


import java.math.BigInteger;

/**
 * hashtable
 *
 * @author leoill
 * @date 2019年5月6日
 */
public class HashTable {
    private LinkList[] arr;

    /**
     * 默认的构造方法
     */
    public HashTable() {
        arr = new LinkList[100];
    }

    /**
     * 指定数组初始化大小
     */
    public HashTable(int maxSize) {
        arr = new LinkList[maxSize];
    }

    /**
     * 插入数据
     */
    public void insert(Info info) {
        //获得关键字
        String key = info.getKey();
        //关键字所自定的哈希数
        int hashVal = hashCode(key);
        if (arr[hashVal] == null) {
            arr[hashVal] = new LinkList();
        }
        arr[hashVal].insertFirst(info);
    }

    /**
     * 查找数据
     */
    public Info find(String key) {
        int hashVal = hashCode(key);
        return arr[hashVal].find(key).info;
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    public Info delete(String key) {
        int hashVal = hashCode(key);
        return arr[hashVal].delete(key).info;
    }

    /**
     * hash化：
     * 1直接将关键字作为索引，
     * 将字母转换为AscII吗然后进行相加
     * 幂的连乘
     * 压缩可选值
     *
     * @param key
     * @return
     */
    public int hashCode(String key) {
        //将字母转换为AscII吗然后进行相加
//		int hashVal = 0;
//		for(int i = key.length() - 1; i >= 0; i--) {
//			int letter = key.charAt(i) - 96;
//			hashVal += letter;
//		}
//		return hashVal;
        //开放地址法，链地址法
        //幂的连乘27是因为有26个字母和空格
        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }
}
