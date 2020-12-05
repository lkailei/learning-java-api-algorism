package com.jzoffer;

/**
 * @Author kay三石
 * @date:2019/6/7
 * 给定一个二维数组，其每一行从左到右递增排列，从上到下递增排序，给定一个数判断是否在其二维数组中。
 * [1,4,7,11,15]
 * [2,5,8,12,19]
 * [3,6,9,16,22]
 * [10,13,14,17,24]-
 */
public class ArrayFind {

    /**
     * 从右上角开始，行从0，列从最后一列的第一个，
     * 当判断到第一列最后一行结束，
     * 当寻找的与下标相同的话结束；
     * 如果不同则大于的话向下一行走；
     * @param targert
     * @param matrix
     * @return
     */
    public boolean find(int targert,int[][] matrix){
        if (matrix==null|| matrix.length==0||matrix[0].length==0){
            return true;
        }
        int rows=matrix.length,clos=matrix[0].length;
        int r=0,c=clos-1;//从右上角开始
        while(r<=rows-1&&c>=0){
            if (targert==matrix[r][c]) return  true;
            else if (targert>matrix[r][c]) r++;
            else c--;
        }
            return  false;
    }

    /**
     * 这个不知道正确与否，个人感觉没任何问题
     * 给上面累似的方式；从最下方开始，最下方的是最大的。
     * @param targert
     * @param matrix
     * @ToDo 检查这个方法的可行性。
     * @return
     */
    public boolean find1(int targert,int[][] matrix){
        if (matrix==null|| matrix.length==0||matrix[0].length==0){
            return true;
        }
        int rows=matrix.length,clos=matrix[matrix.length].length;
        int r=matrix.length,c=clos-1;//从右下角
        while(r>=0&&c<=clos-1){
            if (targert==matrix[r][c]) return  true;
            else if (targert<matrix[r][c]) r--;
            else c--;
        }
        return true;
    }

}
