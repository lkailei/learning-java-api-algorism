package com.kaysanshi.testArray;

/**
 * 双向循环链表
 * 双向循环链表不只是只有头指针head,还有尾结点end
 *
 * @Author kaysanshi
 * @date:2020/12/6
 */
public class LinkedListTwowaycircular {
    /**
     * 这是每个节点域
     *
     * @author leoill
     * @date 2019年4月25日
     * <p>
     * class Node {
     * //数据域
     * public long data;
     * <p>
     * //结点域
     * //指针域
     * public com.kaysanshi.testArray.Node next;
     * <p>
     * //前一个指针域
     * public com.kaysanshi.testArray.Node privious;
     * <p>
     * public Node(long value) {
     * this.data = value;
     * }
     * <p>
     * public Node() {
     * }
     * <p>
     * public Node(long data, com.kaysanshi.testArray.Node next) {
     * this.data = data;
     * this.next = next;
     * }
     * <p>
     * public Node(long data, com.kaysanshi.testArray.Node next, com.kaysanshi.testArray.Node privious) {
     * this.data = data;
     * this.next = next;
     * this.privious = privious;
     * }
     * }
     */

    Node head;
    Node end;
    int size;
    long t;

    //初始化链表
    public void initlist() {
        end = new Node();
        head = new Node(0, null, end);
        // 这个地方进行初始化的时候是将下个尾节点的next指向头部
        end.privious = head;
        end.next = head;
        size = 0;
    }

    //获取长度
    public int length() {
        return size;
    }

    //获取节点
    public Node getNode(int index) {
        Node n;
        // 判断index是否大于中间的
        if (index >= size / 2) {
            // 若大于，说明节点是偏后的，因此从end开始一路prev上去
            n = end;
            // 获取结点的
            for (int i = length(); i > index; i--) {
                n = n.privious;
            }
            return n;
        } else {
            // 若小于，说明节点是偏前的，因此从head开始一路next下去
            n = head;
            for (int i = 0; i <= index; i++) {
                n = n.next;
            }
            return n;
        }
    }

    //添加元素
    public void add(long a) {
        Node renode = new Node(a, getNode(size - 1), end);
        renode.privious.next = renode;
        renode.next.privious = renode;
        size++;
    }

    //插入元素
    public void insert(int i, long a) {
        // 获取待插入元素的节点node
        Node n = getNode(i);
        // 创建一个节点newnode，next指向node，prev指向node.prev
        Node newNode = new Node(a, n.privious, n);
        // 把node.prev该节点的next指向新的结点
        n.privious.next = newNode;
        // 把node的前一个节点prev指向新的node
        n.privious = newNode;
        size++;
    }

    //删除元素
    public long remove(int i) {
        // 获取待删除元素的节点node
        Node n = getNode(i);
        long data = n.data;
        // 把node前一个节点的next指针设置为node的后一个节点
        n.privious.next = n.next;
        // 把node后一个节点的prev指针设置为node的前一个节点
        n.next.privious = n.privious;
        // 由于没有指针指向node,node会被自动清理 令其size减一
        size--;
        return data;
    }

    //获取i位置的数据
    public long get(int i) {
        return getNode(i).data;
    }

    //为i位置元素重新赋值
    public long set(int i, long a) {
        Node n = getNode(i);
        long old = n.data;
        n.data = a;
        return old;

    }

    //清空链表
    public void clear() {
        initlist();
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(getNode(i).data);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListTwowaycircular list = new LinkedListTwowaycircular();
        list.initlist();
        list.add(1);
        list.add(2);
        list.print();
    }
}
