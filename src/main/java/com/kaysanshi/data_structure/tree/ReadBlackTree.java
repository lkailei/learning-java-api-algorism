package com.kaysanshi.data_structure.tree;

/**
 * 二叉树中的情况：比如有序的 1-10，这样就会只有右子树，所以当左右深度相差过多，
 * 在使用平衡情况下的二叉查找树是时间复杂度为logn，而出现这种极端情况的话，想要查9的位置就需要每一次都遍历下一个右子树，很有可能时间复杂度变为n(与数组普通查询的时间复杂度相同)
 * <p>
 * 基于上面的情况出现了平衡二叉树，红黑树即为平衡二叉树的一种
 * 红黑树：是为了解决二叉树中的出现不平衡的序列，
 * 特点：
 * 节点是红色或黑色
 * 根节点一定为黑色
 * 每个节点都是黑色的空节点
 * 每个红节点的两个子节点都是黑色的	(从每个叶子到跟的所有路径上不能有两个连续的红节点)
 * (即对于层来说除了NIL节点，红黑节点是交替的，第一层是黑节点那么其下一层肯定都是红节点，反之一样)
 * 从任一节点到其每个叶子节点的所有路径都包含相同数目的黑色节点
 * 左旋：如果左子树深度过深，那么便需要左旋操作以保证左右子树的深度差最小
 * 右旋：右旋与左旋的概念正好相反
 * 通过左旋和右旋可以实现红黑树
 *
 * @author leoill
 * @date 2019年4月29日
 */
public class ReadBlackTree {
    TreeNode grandParent;

    /**
     * 左旋：
     *
     * @param presentNode
     * @return
     */
    public TreeNode singleRotateWithLeft(TreeNode presentNode) {
        TreeNode node;        //新的父节点
        node = presentNode.rightChild;
        presentNode.rightChild = node.leftChild;
        node.leftChild = presentNode;
        return node;
    }

    /**
     * 右旋
     *
     * @param presentNode
     * @return
     */
    public TreeNode singleRotateWithRight(TreeNode presentNode) {
        TreeNode node;
        node = presentNode.leftChild;
        presentNode.leftChild = node.rightChild;
        node.rightChild = presentNode;
        return node;
    }

    /**
     * 插入：被插入的节点是根节点
     *
     * @param presentNode
     */
    public void insert_case1(TreeNode presentNode) {
        if (presentNode.parent == null) {
            presentNode.color = "black";
        } else {
            insert_case2(presentNode);
        }
    }

    /**
     * 被插入的节点的父节点是黑色
     *
     * @param presentNode
     */
    public void insert_case2(TreeNode presentNode) {
        if (presentNode.parent.color.equals("black")) {
            // do nothing
        } else {
            insert_case3(presentNode);
        }
    }

    /**
     * 叔叔节点是红色
     * 处理方式：
     * 将 "父节点" 设为黑色
     * 将 "叔叔节点" 设为黑色
     * 将 "祖父节点" 设为红色
     * 将 "祖父节点" 设为 "当前节点"(红色节点)；之后继续对 "当前" 进行操作。
     *
     * @param presentNode
     */
    public void insert_case3(TreeNode presentNode) {
        if (presentNode.uncle != null && presentNode.uncle.color.equals("red")) {
            presentNode.parent.color = "black";
            presentNode.uncle.color = "black";
            grandParent.color = "red";
            insert_case1(grandParent);
        } else {
            insert_case4(presentNode);
        }
    }

    /**
     * 叔叔节点为黑色或缺失，且当前节点是曲线边 (即左右或右左)
     * 处理方式：
     * <p>
     * 将 "父节点" 作为 "新的当前节点"
     * 以 "新的当前节点" 为支点进行左旋
     * 以新的当前节点(即原本的父节点)再进行操作
     */
    public void insert_case4(TreeNode presentNode) {
        if (presentNode == presentNode.parent.rightChild && presentNode.parent == presentNode.grandParent.leftChild) {
            singleRotateWithLeft(presentNode.parent);
            presentNode = presentNode.leftChild;
        } else if (presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.rightChild) {
            singleRotateWithRight(presentNode.parent);
            presentNode = presentNode.rightChild;
        }
        insert_case5(presentNode);
    }

    public void insert_case5(TreeNode presentNode) {
        presentNode.parent.color = "black";
        presentNode.grandParent.color = "red";
        if (presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.leftChild) {
            singleRotateWithRight(presentNode);
        } else {
            singleRotateWithLeft(presentNode);
        }
    }

    /**
     * 迭代实现插入操作
     */
    public void insert_case(TreeNode presentNode) {

        while (presentNode != null) {
            if (presentNode.parent == null) {
                presentNode.color = "black";
                break;
            } else if (presentNode.parent.color.equals("black")) {
                //do nothing
                break;
            } else if (presentNode.uncle != null && presentNode.uncle.color.equals("red")) {

                presentNode.parent.color = "black";
                presentNode.uncle.color = "black";
                presentNode.grandParent.color = "red";
                presentNode = presentNode.grandParent;

            } else if (presentNode == presentNode.parent.rightChild && presentNode.parent == presentNode.grandParent.leftChild) {

                singleRotateWithLeft(presentNode.parent);
                presentNode = presentNode.leftChild;

            } else if (presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.rightChild) {

                singleRotateWithRight(presentNode.parent);
                presentNode = presentNode.rightChild;

            } else {

                presentNode.parent.color = "black";
                presentNode.grandParent.color = "red";
                if (presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.leftChild) {
                    singleRotateWithRight(presentNode);
                } else {
                    singleRotateWithLeft(presentNode);
                }

            }
        }
    }
}

class TreeNode {
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;
    TreeNode grandParent;
    TreeNode uncle;
    String color;

    public TreeNode() {
        grandParent = this.parent.parent;
        if (this.parent == grandParent.leftChild) {
            uncle = grandParent.rightChild;
        } else {
            uncle = grandParent.leftChild;
        }
    }
}
