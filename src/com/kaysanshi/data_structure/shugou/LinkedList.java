package com.kaysanshi.data_structure.shugou;

public class LinkedList {
	private Node head;//头结点
	private Node last;//尾结点；
	private int size;
	//初始化头尾结点；
	public LinkedList(){
		head=new Node();
		last=head;
	}
	//增加的方法；在链表后增加；
	public boolean add(Object obj){
		Node newNode=new Node();
		newNode.setData(obj);
		last.setNext(newNode);
		last=newNode;
		size++;
		return true;
	}
	//删除的方法；
	public Object remove(int index){
		if(index==0){
			head=head.getNext();
			return null;
		}
		Node before=head;
		for(int i=0;i<index;i++){
			before=before.getNext();
		}
		Node current=before.getNext();
		before.setNext(current.getNext());
		current.setNext(null);
		size--;
		return current.getData();
	}
	//插入的方法；
	 public void insert(int index,Object obj){  
	     Node node=head;
	     int j=0;  
	     while(node!=null&&j<index-2){  
	         //查找到第index-1个元素  
	         node=node.getNext();  
	         j++; 
	     }  
	     Node sert=new Node();//被插入的结点  
	     sert.setData(obj);
	     sert.setNext(node.getNext());  
	     node.setNext(sert);
	     size++;
	 }
	 
	//改变指定位置的元素 等于覆盖原先的元素；
	 public void modify(int index,Object obj){  
	     Node node=head;
	     int j=0;  
	     while(node!=null&&j<=index){  
	         //找到第index个结点  
	         node=node.getNext();  
	         j++;  
	     }  
	     node.setData(obj);
	 }
	//查找的方法：无效；
	public Object get(Object obj){
		Node current=head;//头结点
		Object data=current.getData();//头结点的值
		while(current.getNext()!=null){//循环判断是否相等；
			if(current.getNext().getData().equals(obj)){
				data=current.getNext().getData();//获取值
				System.out.println(data);
			}else{
				System.out.println("没有这个数据");
				break;
			}
			current=current.getNext();
		}
		return data;
	}
	//查找按造下标查找；
	public Object find(int index){
		Node current=head;
		for(int i=0;i<size;i++){
			
		}
		return current;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		//sb.append("[");
		Node currentNode=head;
		while(true){
			if(currentNode.getNext()!=null){
				currentNode=currentNode.getNext();
				sb.append(currentNode.getData()+"  ");
			}else{
//				System.out.println("这是个空链表");
				break;
			}
		}
		//sb.append("]");
		return sb.toString();
		
	}
}
