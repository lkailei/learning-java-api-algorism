package com.kaysanshi.testArray;
/**
 * 双向链表
 * @author kaysanshi
 *@date 2019年4月26日
 */
public class DoubleLinkList_double {
	//链表的头结点
			private Node first;
			//尾节点
			private Node last;
			
			public DoubleLinkList_double() {
				// TODO Auto-generated constructor stub
				first=null;
				last=null;
			}
			/**
			 * 从头结点后进行插入 要对链表判断，判断是否weinul。如果weinull.则设置尾结点为新添加的结点；，如果不为null
			 * 设置头结点的前一个结点为新添加的结点
			 * @param value
			 */
			public void insert(long value){
				Node node=new Node(value);
				if (isEmpty()) {
					//把尾节点为第一次添加的
					last=node;
				}else{
					first.privious=node;
				}
				node.next=first;
				first=node;
			}
			/**
			 * 从尾节点进行插入：如果链表为null则直接设置头结点为新添加的结点，否则设置尾结点的后一个结点为新添加结点
			 * 同时设置新添加的节点的前一个结点为尾结点
			 */
			public void insertLast(long value){
				Node node=new Node(value);
				if (isEmpty()) {
					first=node;
				}else{
					last.next=node;
					node.privious=last;
				}
				last=node;
			}
			/**
			 * 从头部删除的第一个节点:判断头结点是否有下一个结点，如果没有则设置尾节点为null,否则设置头结点的下一个结点的
			 * previous为null;
			 * @return
			 */
			public Node deleteFisrt(){
				//把下一个节点给接受
				Node temp=first;
				if (first.next == null) {
					last=null;
				}else{
					first.next.privious=null;
				}
				first=temp.next;
				return temp;
			}
			/**
			 * 删除节点 从尾部删除
			 * 判断头结点是否有下一个结点，如果没有则设置头节点为null,否则设置尾结点的下一个结点的
			 * next为null;
			 */
			public Node deleteLast(){
				Node temp=last;
				if (first.next==null) {
					first=null;
				}else{
					last.privious.next=null;
					
				}
				last=last.privious;
				return last;
			}
			/**
			 * 显示的方法
			 */
			public void display(){
				Node current=first;
				//当前的节点不为null
				while(current!=null){
					current.display();
					current=current.next;
				}
			}
			/**
			 * 查找
			 * @param value
			 * @return
			 */
			public Node find(long value){
				Node current=first;
				while(current.data!=value){
					//下一个没有了终止
					if (current.next==null) {
						return null;
					}
					//指向下一个元素
					current=current.next;
				}
				return current;
			}
			/**
			 * 删除的方法：返回删除的数据
			 * @param value
			 * @return
			 */
			public Node delete(long value){
				//当前的节点
				Node current=first;

				while(current.data != value){
					if (current.next==null) {
						return null;
					}
					
					current=current.next;
				}
				if (current==first) {
					
					first=first.next;
					
				}else{
					current.privious.next=current.next;
				}
				return current;
			}
			/**
			 * 判断weinull
			 * @return
			 */
			public boolean isEmpty(){
				return (first==null);
			}
}
