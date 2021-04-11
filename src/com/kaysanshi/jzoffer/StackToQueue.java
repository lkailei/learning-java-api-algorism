package com.kaysanshi.jzoffer;


import java.util.Stack;

/**
 * user:kay三石
 * time: 17:02
 * desc:用栈模拟一个队列，要求实现队列的两个基本操作：入队和出队
 *
 **/
public class StackToQueue {
    private Stack<Integer> stackA=new Stack<>();
    private Stack<Integer> stackB=new Stack<>();

    /**
     * 入队操作
     * @param element 入队的元素
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    public Integer deQueue(){
        if(stackB.isEmpty()){
            if (stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 将A的元素转移到b中
     */
    private void transfer() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue=new StackToQueue();
        stackToQueue.enQueue(1);
        stackToQueue.enQueue(2);
        stackToQueue.enQueue(3);
        stackToQueue.enQueue(4);
        System.out.println(stackToQueue.deQueue());
    }
}
