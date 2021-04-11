package com.kaysanshi.jzoffer;

/**
 * @Author kay三石
 * @date:2019/6/7
 * 去除一个个长度为n的一维数组总的重复的数字，但是不知道有多个重复的，请找出任意一个重复的数字。
 * 如{2,3,1,3,0,2,5,3}
 */
public class ArrayTest2 {
    /**
     * 传入一个数组，并指定长度，并同时设定一个新的数组
     * @param nums
     * @param length
     * @param duplicate
     * @return
     */
    public boolean duplicate(int[] nums,int length,int[] duplicate){
        if (nums==null||length==0){
            return false;
        }
        for (int i=0;i<length;i++){
            while(nums[i]!=i){
                if (nums[i]==nums[nums[i]]){
                    duplicate[0]=nums[i];
                    return  true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    /**
     * 数据交换
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
