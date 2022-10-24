package com.kaysanshi.data_structure.testArray;

/***
 * 构造一个属于自己的数组
 * @author leoill
 *@date 2019年4月23日
 */
public class Array {

    private long[] arry;//定义一个数组

    private int elements;//定义数据有效长度

    public Array() {
        arry = new long[50];//设置50长度
    }

    public Array(int maxsize) {
        arry = new long[maxsize];
    }

    /**
     * 数组的数据的添加
     */
    public void insert(long value) {
        arry[elements] = value;
        elements++;
    }

    /**
     * 显示数据
     */
    public void display() {
        System.out.println("[");
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 根据值来返value
     */
    public int search(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (value == arry[i]) {
                break;
            }
        }
        if (i == elements) {
            return -1;
        } else {
            return i;
        }
    }

    /**
     * 线性查找
     * 查找数据根据索引查
     */
    public long get(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arry[index];
        }
    }

    /**
     * 删除数据
     */
    public void delete(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = 0; i < elements; i++)
                arry[index] = arry[index + 1];
            elements--;
        }
    }

    /**
     * 更新
     *
     * @param index
     * @param newvalue
     */
    public void update(int index, long newvalue) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arry[index] = newvalue;
        }
    }
    ///////////////////////////
    // 以下是有序数组的操作                ///
    //                      //
    //                     ///
    //////////////////////////

    /**
     * 有序添加
     *
     * @param value
     */
    public void sortinsert(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (arry[i] > value) {
                break;
            }
        }
        //这里是最后一个元素赋值给前一个元素，同时把新加入的元素给赋值到下标i;元素总量+1；
        for (int j = elements; j > i; j--) {
            arry[j] = arry[j - 1];
        }
        arry[i] = value;
        elements++;
    }

    /**
     * 二分查找:前提是必须是有序的数组
     *
     * @return
     */
    public int binarysearch(long value) {
        int middle = 0;
        int low = 0;
        int pow = elements;//最大下标
        while (true) {
            middle = (pow + low) / 2;
            if (arry[middle] == value) {
                return middle;

            } else if (low > pow) {
                return -1;
            } else {
                if (arry[middle] > value) {
                    pow = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }


    /***
     * 测试
     * @param args
     */
    public static void main(String[] args) {

    }
}
