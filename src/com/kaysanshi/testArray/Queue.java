package com.kaysanshi.testArray;

/**
 * 队列
 * @author leoill
 *@date 2019年4月24日
 */
public class Queue {
	//底层也是同样的使用数组
	
	private long[] arry;
	//有效数据的大小
	private int elements;
	
	//对头
	private int front;
	
	//队尾
	private int end;
	
	public Queue(){
		arry=new long[10];
		elements=0;
		front=0;
		end=-1;
	}
	/**
	 * 
	 * @param maxsize
	 */
	public Queue(int maxsize){
		arry=new long[maxsize];
		elements=0;
		front=0;
		end=-1;
	}
	/**
	 * 添加数据
	 * 
	 */
	public void insert(long value){
		//end指向最后一个元素时
		if (end ==arry.length-1) {
			end=-1;
		}
		arry[++end]=value;
		elements++;
	}
	/**
	 * 删除数据，从队头删除
	 * @return
	 */
	public long remove(){
		
		long value=arry[front++];
		//判断front的长度
		if (front==arry.length) {
			front=0;
		}
		elements--;
		return value;
	}
	/**
	 * 查看数据
	 */
	public long peek(){
		return arry[front];
	}
	/**
	 * 判断是否为空
	 */
	public boolean isEmpty(){
		return elements==0;
	}
	/**
	 * 判断是队满
	 * @return
	 */
	public boolean isFull(){
		return arry.length==elements;
	}
	/**
	 * 显示数据
	 */
	public void display(){
		
		while(!isEmpty()){
			System.out.println(peek());
		}
	}
}
