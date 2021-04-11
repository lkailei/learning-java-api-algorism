package com.kaysanshi.data_structure.test;

/**
 * @Author kay三石
 * @date:2019/6/4
 * 打印九九乘法表
 */
public class Multable {
    /**
     * 双重循环打印九九乘法表
     */
    public void multableprint(){
        for(int i=1;i<=9;i++){//外层循环控制行，内层循环控制列。
            for(int j=1;j<=i;j++){//每一行有多少列由行确定。
                System.out.print("  "+i+"*"+j+"="+i*j );
            }
            System.out.println();
        }
    }

    /**
     *for循环语句：for(表达式1;表达式2;表达式3)
     * 循环体
     * 执行过程：
     * 1.求解表达式1；
     * 2.求解表达式2，满足到3，否者到5
     * 3.执行一次循环体
     * 4.求解表达式3，转到2，构成循环
     * 5.结束循环，执行for循环后的语句
     *
     */
    public void multableprint1(){
        for (int i=1,j=1;i<=9;){//i控制行，j控制列。
            System.out.print("  "+i+"*"+j+"="+i*j );
            j++;
            if (j>i){
                System.out.println();
                i++;
                j=1;
            }
        }
    }

    public static void main(String[] args){
        Multable multable=new Multable();
        multable.multableprint();
        System.out.println();
        multable.multableprint1();

    }
}
