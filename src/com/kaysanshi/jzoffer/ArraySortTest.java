package com.kaysanshi.jzoffer;

/**
 * user:kay三石
 * time: 21:46
 * desc: 给定一个无序整形数组，如何求出该数组排序后的任意两个相邻元素的最大差值？ 要求时间和空间的复杂度尽可能的低
 * 备注：不可以使用排序算法先排序再计算
 **/
public class ArraySortTest {
    /**
     * 思路：
     * 利用桶排序的思想，根据原数组的长度n,创建一个桶代表一个区间范围其中第一个桶从原数组的最小值min开始，区间跨度是(max-min)/(n-1)
     * 遍历数组，把原数组的每一个元素插入到对应的桶中，记录每一个桶的最大和最小值。
     * 便利桶，统计出每个桶的最大值和这个桶右侧非空桶的最小值的差，数值最大的差即为原数组排序后的相邻最大差值
     * @param array
     * @return
     */
    public static int getMaxSortedDistance(int[] array){
        // 得到原数组的最大值和最小值
        int max=array[0];
        int min=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        int d=max-min;
        // 如果max和min相等，说明数组所有元素都相等返回0
        if(d==0){
            return 0;
        }
        // 初始化
        int bucketNum =array.length;
        Bucket[] buckets=new Bucket[bucketNum];
        for(int i=0;i<bucketNum;i++){
            buckets[i] = new Bucket();
        }

        // 便利原数组，确定每一个桶的最大最小值
        for(int i=0;i<array.length;i++){
            // 确定数组元素所归属的桶下标
            int index =((array[i]-min)*(bucketNum-1)/d);
            if(buckets[index].min == null || buckets[index].min>array[i]){
                buckets[index].min = array[i];
            }
            if(buckets[index].max == null || buckets[index].max<array[i]){
                buckets[index].max = array[i];
            }
        }
        // 遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance=0;
        for(int i=1;i<buckets.length;i++){
            if(buckets[i].min == null){
                continue;
            }
            if (buckets[i].min-leftMax >maxDistance){
                maxDistance = buckets[i].min-leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket{
        Integer min;
        Integer max;
    }

    public static void main(String[] args) {
        int[] array=new int[]{2,4,56,7,9,10,56};
        System.out.println(getMaxSortedDistance(array));

    }
}
