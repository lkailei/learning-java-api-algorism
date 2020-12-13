package com.kaysanshi.testArray;

/**
 * 递归高级应用
 * 汉诺塔:
 *
 * @author leoill
 * @date 2019年4月27日
 */
public class HighFibonacci {

    /**
     * 移动盘子
     *
     * @param TopN  移动的盘子数
     * @param from  起始的塔坐
     * @param inter 中间塔座
     * @param end   目标塔座
     */
    public static void doTower(int TopN, char from, char inter, char end) {
        if (TopN == 1) {
            System.out.println("盘子1,从" + from + "塔座，到" + end + "塔座");
        } else {
            //先把上面的这些移到end，目的为inter
            doTower(TopN - 1, from, end, inter);
            System.out.println("盘子" + TopN + "从" + from + "塔座，到" + end + "塔座");
            //把盘子移到from,然后变换
            doTower(TopN - 1, inter, from, end);
        }
    }


    public static void main(String[] args) {
        HighFibonacci.doTower(3, 'A', 'B', 'C');
    }

}
