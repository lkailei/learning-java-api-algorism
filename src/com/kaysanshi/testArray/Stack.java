package com.kaysanshi.testArray;

/**
 * 栈的构造及其使用：
 * 后进先出
 *
 * @author leoill
 * @date 2019年4月24日
 */
public class Stack {
    //底层的实现是一个数组
    private long[] arry;

    private int top;//栈顶元素

    public Stack() {
        arry = new long[10];
        top = -1;

    }

    /**
     * 有参构造初始化
     *
     * @param maxsize
     */
    public Stack(int maxsize) {
        arry = new long[maxsize];
        top = -1;
    }

    /**
     * 添加数据
     */
    public void push(int value) {
        arry[++top] = value;
    }

    /**
     * 移除数据
     *
     * @return
     */
    public long pop() {
        return arry[top--];
    }

    /**
     * 查看栈顶数据
     */
    public long peek() {
        return arry[top];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断是否满
     *
     * @return
     */
    public boolean isFull() {
        return top == arry.length - 1;
    }

}
