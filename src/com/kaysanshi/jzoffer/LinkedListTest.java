package com.kaysanshi.jzoffer;

/**
 * user:kay三石
 * time: 21:04
 * desc: 验证环形链表：
 * 解题思路：创建两个指针p1和p2 让他们两个同时指向这个链表的头节点，然后开始循环，让p1每次移动一个节点，让p2每次移动2个节点，然后比较两个指针是否相同
 * 如果相同就是有环
 **/
public class LinkedListTest {
    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;

        while(p2!=null && p2.next !=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个链表如果链表有环求出环的长度。
     * 当已经是环了，那么再让其走一圈即可算出环的长度。即继续向下循环当再次的出现则就是可以计算环的长度
     * @param head
     * @return
     */
    public static int cauCycleLength(Node head){
       Node p1 = head;
       Node p2 =head;
       while (p2!=null && p2.next !=null){
           p1 =p1.next;
           p2 = p2.next.next;
           if(p1==p2){
               int length =0;
               // 继续向下循环
               while(p2!=null && p2.next !=null){
                   p1 = p1.next;
                   p2 =p2.next.next;
                   length++;
                   if(p1==p2){
                       return length;
                   }
               }
           }
       }
       return 0;
    }

    /**
     * 给定一个链表计算是否有环如果有环则返回入的节点.
     * 解题思路：
     * 对于链表的头节点到入环的距离等于从首次相遇点绕环n-1圈再回到入环点的距离，这样就是让其中一个指针放到头节点位置
     * 另一个指针保持在首次相遇的点，两指针都是向前走一步，那么他们最终的相遇节点就是入环点。
     * @param head
     * @return
     */
    public static Node cacCycleNode(Node head){
        Node result=head;
        Node p1 = head;
        Node p2 =head;
        Node p3 = head;
        while (p2!=null && p2.next !=null){
            p1 =p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                p3=p1;
                while(p3!=null && p3.next!=null){
                    result=result.next;
                    p3=p3.next;
                    if(result==p3){
                        return result;
                    }
                }

            }
        }
        return result;
    }

   private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
   }

    public static void main(String[] args) {
        Node node1 =new Node(5);
        Node node2 =new Node(3);
        Node node3 =new Node(7);
        Node node4 =new Node(2);
        Node node5 =new Node(6);
        Node node6 =new Node(4);
        Node node7 =new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node3;
        System.out.println(isCycle(node1));
        System.out.println(cauCycleLength(node1));
        System.out.println(cacCycleNode(node1).data);
        /**
         * ~ output
         * true
         * 5
         * 7
         */
    }
}

