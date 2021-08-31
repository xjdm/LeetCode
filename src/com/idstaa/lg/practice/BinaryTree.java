package com.idstaa.lg.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenjie
 * @date 2021/6/4 14:19
 * 二叉树遍历
 */
public class BinaryTree {
    TreeNode root;

    public void insertNode(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {
        //如果是空则插入第一个节点
        if (node == null) return new TreeNode(data);
        //插左边
        if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        }
        //插右边
        else if (data > node.data) {
            node.rightChild = insert(node.rightChild, data);
        } else {
            node.data = data;
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 前序遍历
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        BinaryTree btt = new BinaryTree();
        btt.insertNode(8);
        btt.insertNode(6);
        btt.insertNode(7);
        btt.insertNode(4);
        btt.insertNode(3);

        btt.postOrderTraveral(btt.root);
    }

    /**
     * 层序遍历
     */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }
}
