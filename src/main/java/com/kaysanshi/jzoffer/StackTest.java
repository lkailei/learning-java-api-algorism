package com.kaysanshi.jzoffer;


import java.util.Stack;

/**
 * user:kay三石
 * time: 21:47
 * desc: 实现一个栈，该栈带有出栈pop,入栈push,取最小值getMin3个方法保证复杂度wei O(1)
 * 思路：使用辅助栈
 **/
public class StackTest {
    private Stack<Integer> mainStack = new Stack();
    private Stack<Integer> minStack = new Stack();

    /**
     * 入栈
     * @param element
     */
    public void push(int element){
        mainStack.push(element);
        // 如果辅助栈为空，或者新元素小于或等于辅助栈栈顶，则将新元素入辅助栈
        if(minStack.empty() || element<minStack.peek()){
            minStack.push(element);
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
        // 如果出栈元素和辅助栈栈顶元素值相等，辅助栈出栈
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if (minStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        StackTest stack = new StackTest();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.push(3);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
