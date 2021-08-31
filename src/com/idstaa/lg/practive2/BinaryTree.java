package com.idstaa.lg.practive2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenjie
 * @date 2021/6/9 19:00
 */
public class BinaryTree {
    TreeNode root;

    public void insertNode(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {
        //如果是空则插入第一个节点
        if (node == null) return new TreeNode(data);
        if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insert(node.rightChild, data);
        } else {
            node.data = data;
        }
        return node;
    }

    // 遍历
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    // 遍历
    public void innerOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        innerOrderTraveral(node.leftChild);
        System.out.println(node.data);
        innerOrderTraveral(node.rightChild);
    }

    // 遍历
    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        innerOrderTraveral(node.leftChild);
        innerOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.data);
            if(poll.leftChild!=null){
                queue.offer(poll.leftChild);
            }
            if(poll.rightChild!=null){
                queue.offer(poll.rightChild);
            }
        }

    }

    //广度优先遍历

    public static void main(String[] args) {
        BinaryTree btt = new BinaryTree();
        btt.insertNode(6);
        btt.insertNode(8);
        btt.insertNode(7);
        btt.insertNode(4);
        btt.insertNode(3);
        btt.levelOrderTraversal(btt.root);

    }
}
