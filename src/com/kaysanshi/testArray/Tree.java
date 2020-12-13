package com.kaysanshi.testArray;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 树中能够快速的查找数据项，和插入数据项，删除数据项
 * 树的概念：
 * 路径：顺着连接节点的边从一个节点到另一个节点，所经历的节点顺序
 * 根节点：树最上面的节点称为根节点，一棵树只有一个根，而且根到任何一个节点有且只有一条路径
 * 父节点：每个节点都有一条边向上连接到另一个节点，这个节点就称是下面的节点的父节点
 * 子节点：每个节点都有一条边向下连接到另一个节点，下面的节点称为该节点的子节点
 * 叶子节点：没有子节点的节点称为叶子节点
 * 子树：每个节点都可以作为一个子树的根，它和它所有的子节点，子节点的节点组合起来就是一个子树
 * 遍历：先序，中序，后序
 * 前序：1.访问根节点,2，左子树，3.右子树
 * 中序：左 ，根， 右
 * 后序 左，右，根
 * 访问：访问一个节点是为了在这个节点上执行一些操作，如查看节点的数据项，但是如果仅仅是经过一个节点，不认为是访问了这个节点
 * 层:一个节点的层数是指从根节点开始到这个节点有多少代
 * 二叉树：
 * 树的节点最多有两个子节点，称为二叉树
 *
 * @author leoill
 * @date 2019年4月28日
 */
public class Tree {
    //根
    private TreeNode root;

    /**
     * 插入节点：
     * 从根节点开始查找一个相应的节点，这个节点将称为新插入的节点的父节点。
     * 当父节点找到后通过判断新节点值的大小决定连接在左节点还是右节点
     *
     * @param value
     */
    public void insert(long value) {
        //封装节点
        TreeNode node = new TreeNode(value);
        //引用当前节点
        TreeNode current = root;
        //引用父节点

        TreeNode parent;
        //如果root为null，也就是第一个插入的时候
        if (root == null) {
            root = node;
            return;
        } else {
            while (true) {
                //父节点指向当前的节点
                parent = current;
                //如果当前的指向的节点的数据比插入的大，则向左走
                if (current.data > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }

            }
        }
    }

    /**
     * 两个参数的
     *
     * @param value
     */
    public void insert(long value, String string) {
        //封装节点
        TreeNode node = new TreeNode(value, string);
        //引用当前节点
        TreeNode current = root;
        //引用父节点

        TreeNode parent;
        //如果root为null，也就是第一个插入的时候
        if (root == null) {
            root = node;
            return;
        } else {
            while (true) {
                //父节点指向当前的节点
                parent = current;
                //如果当前的指向的节点的数据比插入的大，则向左走
                if (current.data > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }

            }
        }
    }

    /**
     * 查找节点
     *
     * @param value
     */
    public TreeNode find(long value) {
        //引用一个当前节点，从根节点开始
        TreeNode current = root;
        //循环：只要查找的节点不等于当前节点的数据项
        while (current.data != value) {
            //进行比较，小于value则在右子树查找，否则在左边查找
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 删除二叉树节点
     * 删除之前首先要查找要删的节点，找到节点后，这个删除的节点可能有以下情况
     * 1.该节点是叶子节点，没有子节点：要删除叶节点，只需改变该节点的父节点的引用，将指向该节点的引用设置为null就可以了
     * 2.该节点有一个子节点：改变父节点的引用，将其指向要删除的节点的子节点、
     * 3.该节点有两个子节点，要删除有两个子节点的节点，就需要使用它的中序后继来替代该节点
     *
     * @param value
     * @return
     */
    public boolean delete(long value) {
        //引用当前节点，从根节点开始
        TreeNode current = root;
        //应用当前节点的父节点
        TreeNode parent = root;
        //是否为左节点
        boolean isLeftNode = true;
        while (current.data != value) {
            parent = current;
            //这里是比较当前的值和当前节点的大小
            if (current.data > value) {
                //如果当前值大于删除的值，则则向左面查找
                current = current.leftChild;
                isLeftNode = true;
            } else {
                //如果当前值小于删除的值则向右面查找，直到找到
                current = current.rightChild;
                isLeftNode = false;
            }
            //如果找不到
            if (current == null) {
                return false;
            }
        }
        //删除叶子节点，也就是该节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            //如果是根
            if (current == root) {
                root = null;
                //如果 它是父节点的左子节点
            } else if (isLeftNode) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

            //删除的节点只有左子节点
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftNode) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            //删除的节点只有右子节点
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftNode) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            //删除的节点
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftNode) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }

        //表示删除成功
        return true;

    }

    /**
     * 中序后继节点，
     *
     * @param delNode
     * @return
     */
    public TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successor = delNode;
        TreeNode successorParent = delNode;
        TreeNode current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;

        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    /**
     * 前序遍历:前序：1.访问根节点,2，左子树，3.右子树
     * 使用递归遍历
     *
     * @param localNode
     */
    public void frontTraversal(TreeNode localNode) {
        if (localNode != null) {
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sdata);
            //前序遍历左子树
            frontTraversal(localNode.leftChild);
            //前序遍历右子树
            frontTraversal(localNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * 递归遍历
     * 中序：左 ，根， 右
     * 就是会从小到大一次排列
     *
     * @param localNode
     */
    public void centerTraversal(TreeNode localNode) {
        //先中序遍历左子树
        if (localNode != null) {
            //中序遍历左子树
            centerTraversal(localNode.leftChild);
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sdata);
            //中序遍历右子树
            centerTraversal(localNode.rightChild);
        }
    }

    /**
     * 后序遍历:
     * 左 ,右,根
     *
     * @param localNode
     */
    public void lastTraversal(TreeNode localNode) {
        if (localNode != null) {
            //后序遍历左子树
            lastTraversal(localNode.leftChild);
            //后序遍历右子树
            lastTraversal(localNode.rightChild);
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sdata);
        }
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1, "zhang");
        tree.insert(12, "ASD");
        tree.insert(13, "BHD");
        tree.insert(14, "HUA");
        tree.insert(10, "DOS");
        tree.insert(11, "NOD");
        tree.centerTraversal(tree.root);
        //删除子节点没有
        tree.delete(1);
        System.out.println();
        tree.centerTraversal(tree.root);
        System.out.println();
        //删除删除该节点有一个子节点
        tree.delete(11);
        tree.centerTraversal(tree.root);
        System.out.println();
        //删除
        tree.delete(14);
        tree.centerTraversal(tree.root);
    }

}

/**
 * 二叉树节点
 *
 * @author leoill
 * @date 2019年4月28日
 */
class TreeNode {
    //数据项
    public long data;
    //数据项
    public String sdata;
    //左子节点
    public TreeNode leftChild;
    //右子节点

    public TreeNode rightChild;

    public TreeNode(long data, String sdata) {
        this.data = data;
        this.sdata = sdata;
    }

    public TreeNode(long data) {

        this.data = data;
    }

}
