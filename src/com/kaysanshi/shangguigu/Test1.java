package com.kaysanshi.shangguigu;

/**
 * @Author kay三石
 * @date:2019/6/2
 */
public class Test1 {
    public static void main(String[] args){
        int i=1;
        i=i++;  //i++是2,然后赋值到i变量，
        int j=i++; //i++中的放到,1
        int k=i+ ++i*i++;//11
        System.out.print("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
        //局部变量     操作栈     结果
        //i=1         把1压入    i=1
        //i++         i++压入栈这里还是2 但结果还是1
        //2           把i++压入结果还是1
        //=右边的从左到右加载值依次压入操作栈。
        //自增自减都是直接修改变量的值，不经过操作栈。
        //最后赋值前临时结果也是存储在操作栈中

    }
}
