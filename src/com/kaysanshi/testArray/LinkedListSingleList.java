package com.kaysanshi.testArray;

/**
 * 单链表 循环链表
 * @Author kay三石
 * @date:2020/12/6
 * 对于循环链表而言，关键要素是指定链表的头节点head、尾节点tail以及链表大小size；
 * 该数据结构支持在头部增加节点、在尾部增加节点，从头部删除节点及从尾部删除节点等
 */
public class LinkedListSingleList {
    // 使用的是Node节点

    /**
     *  //数据域
     * 	public long data;
     *
     * 	//结点域
     * 	//指针域
     * 	public Node next;
     *
     * 	//前一个指针域
     * 	public Node privious;
     *
     * 	public Node(long value){
     * 		this.data=value;
     *  }
     */
    private Node head; // 头节点

    private Node tail; // 尾节点

    int size;

    public LinkedListSingleList(){
        this.tail = this.head = null;
        this.size = 0;
    }

    /**
     * 从链表头部增加节点
     * @param node
     */
    public void addNodetoHead(Node node) {
        // 如果使用该方法增加链表的第一个节点，则head=tail=node，且next指向自身
        if(size==0){
            //将节点增加链表的下一个执行自身
            node.next = node;
            tail =head =node;
            size++;
        }else{
            // 将尾结点指向这个新的节点
            tail.next = node;
            // 将该结点的下个指针指向头结点
            node.next=head;
            size++;
        }
    }

    /**
     * 从链表的尾部增加节点
     * @param node
     */
    public void addNotetoTail(Node node){
        //如果使用该方法增加链表的第一个节点，则tail=head=node，且next指向自身
        if(size==0){
            tail.next = node;
            tail=head=node;
            size++;
        }else{
            // 将尾结点指向这个新的节点
           tail.next = node;
           // 将该结点的下个指针指向头结点
           node.next = head;
           // 将该节点与尾结点的值相同
           tail = node;
           size++;
        }
    }

    //删除头部节点，被删掉的head将被自动回收
    public void delHead(){
        if(size>1){
            head = head.next;
            tail.next=head;
            size--;
        }
        else if(size==1){
            head = tail = null;
            size--;
        }
        else{
            System.out.println("There is no elements in the linked list.");
        }
    }

    //删除尾部节点
    public void delTail(){
        if(size>1){
            Node nd = new Node();
            nd = head;
            while(nd.next!=tail){
                nd = nd.next;
            }
            nd.next=head;
            size--;
        }
        else if(size==1){
            head = tail = null;
            size--;
        }
        else{
            System.out.println("There is no elements in the linked list.");
        }
    }

    //打印全部节点
    public void printList(){
        Node nd = new Node();
        nd = head;
        try{
            while(nd.next!=head){
                System.out.print(nd.data);
                System.out.print("->");
                nd = nd.next;
            }
            System.out.print(nd.data);
            System.out.print("->");
            System.out.print(head.data);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        // TODO Auto-generated method stub
        LinkedListSingleList lst = new LinkedListSingleList();
        Node head = new Node(11);
        Node head2 = new Node(13);
        lst.addNodetoHead(head);
        lst.addNodetoHead(head2);
        System.out.println("打印链表：");
        lst.printList();

        lst.addNotetoTail(new Node(22));
        lst.addNotetoTail(new Node(33));
        System.out.println("打印链表：");
        lst.printList();
        System.out.println();
        System.out.println("删除首端节点：");
        lst.delHead();
        lst.printList();
        System.out.println();
        System.out.println("删除首端节点：");
        lst.delHead();
        lst.printList();
    }
}
