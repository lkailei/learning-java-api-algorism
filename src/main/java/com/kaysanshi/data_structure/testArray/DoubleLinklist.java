package com.kaysanshi.data_structure.testArray;

/**
 * 双端链表：
 *
 * @author leoill
 * @date 2019年4月26日
 */
public class DoubleLinklist {
    //链表的头结点
    private Node first;
    //尾节点
    private Node last;

    public DoubleLinklist() {
        // TODO Auto-generated constructor stub
        first = null;
        last = null;
    }

    /**
     * 从头结点后进行插入 要对链表判断，判断是否weinul。如果weinull.则设置尾结点为新添加的结点；
     *
     * @param value
     */
    public void insert(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            //把尾节点为第一次添加的
            last = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * 从尾节点进行插入
     */
    public void insertLast(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    /**
     * 从头部删除的第一个节点:判断头结点是否有下一个结点，如果没有则设置尾节点为null
     *
     * @return
     */
    public Node deleteFisrt() {
        //把下一个节点给接受
        Node temp = first;
        if (first.next == null) {
            last = null;
        }
        first = temp.next;
        return temp;
    }

    /**
     * 显示的方法
     */
    public void display() {
        Node current = first;
        //当前的节点不为null
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public Node find(long value) {
        Node current = first;
        while (current.data != value) {
            //下一个没有了终止
            if (current.next == null) {
                return null;
            }
            //指向下一个元素
            current = current.next;
        }
        return current;
    }

    /**
     * 删除的方法：返回删除的数据
     *
     * @param value
     * @return
     */
    public Node delete(long value) {
        //当前的节点
        Node current = first;
        //前一个节点
        Node previous = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first) {

            first = first.next;

        } else {

            previous.next = current.next;
        }
        return current;
    }

    /**
     * 判断weinull
     *
     * @return
     */
    public boolean isEmpty() {
        return (first == null);
    }
}
