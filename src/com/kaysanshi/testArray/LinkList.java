package com.kaysanshi.testArray;

/**
 * 单链表：是由每个结点和结点数据所组成的链表
 *
 * @author kaysanshi
 * @date 2019年4月25日
 */
public class LinkList {
    //链表的头结点
    private Node first;

    public LinkList() {
        first = null;
    }

    /**
     * 插入节点：在头结点后进行插入
     *
     * @param value
     */
    public void insert(long value) {
        Node node = new Node(value);
        //把下一个节点的指向添加的节点
        node.next = first;
        //然后把值给first
        first = node;

    }

    /**
     * 删除一个节点，删除的第一个节点
     *
     * @return
     */
    public Node deleteFisrt() {
        //把下一个节点给接受
        Node temp = first;
        //然后把这个节点指向第一个节点
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
}

/**
 * 这是每个节点域
 *
 * @author leoill
 * @date 2019年4月25日
 */
class Node {
    //数据域
    public long data;

    //结点域
    //指针域
    public Node next;

    //前一个指针域
    public Node privious;

    public Node(long value) {
        this.data = value;
    }

    public Node() {
    }

    public Node(long data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(long data, Node privious,Node next) {
        this.data = data;
        this.next = next;
        this.privious = privious;
    }

    /**
     * 显示的方法
     */
    public void display() {
        System.out.println(data + " ");
    }
}
