package com.idstaa.lg.practive2;

/**
 * @author chenjie
 * @date 2021/6/15 17:02
 */
public class RBTree {
    RBTreeNode root;//根节点

    /**
     * 遍历节点
     */
    public void list(RBTreeNode node) {
        if (node == null) return;
        // 递归终止条件
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(node);
            return;
        }
        System.out.println(node);
        list(node.getLeft());
        list(node.getRight());
    }

    // 插入节点
    public void insert(int key) {
        RBTreeNode node = new RBTreeNode(key);
        // 插入根节点
        if (root == null) {
            node.setBlack(true);
            root = node;
            return;
        }
        RBTreeNode parent = root;
        RBTreeNode son = null;
        // 左孩子
        if (key <= parent.getKey()) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }
        // 递归查找
        while (son != null) {
            parent = son;
            if (key <= parent.getKey()) {
                son = parent.getLeft();
            } else {
                son = parent.getRight();
            }
        }
        // 添加左孩子
        if (key <= parent.getKey()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent);
        // 自平衡
        balanceInsert(node);
    }

    private void balanceInsert(RBTreeNode node) {
        RBTreeNode father, gFather;
        // 父节点是红的
        while ((father = node.getParent()) != null && father.isBlack() == false) {
            gFather = father.getParent();
            // 父节点在祖节点的左边
            if (gFather.getLeft() == father) {
                RBTreeNode uncle = gFather.getRight();
                if (uncle != null && uncle.isBlack() == false) {
                    // 颜色反转
                    setBlack(father);
                    setBlack(uncle);
                    setRed(gFather);
                    node = gFather;
                    continue;
                }
                if (node == father.getRight()) {
                    // 左旋
                    leftRotate(father);
                    // 交换
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(gFather);
                //右旋
                rightRotate(gFather);
            }
            //父节点在祖父节点右边
            else {
                RBTreeNode uncle = gFather.getLeft();
                if (uncle != null && uncle.isBlack() == false) {
                    // 颜色反转
                    setBlack(father);
                    setBlack(uncle);
                    setRed(gFather);
                    node = gFather;
                    continue;
                }
                if (node == father.getRight()) {
                    // 右旋
                    rightRotate(father);
                    // 交换
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(gFather);
                //右旋
                leftRotate(gFather);
            }
        }
        setBlack(root);
    }

    private void rightRotate(RBTreeNode node) {

        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = left;
            left.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);

    }

    private void leftRotate(RBTreeNode node) {
        RBTreeNode right=node.getRight();
        RBTreeNode parent=node.getParent();
        // root
        if(parent==null){
            root=right;
            right.setParent(null);
        }

        else{
            if(parent.getLeft()!=null&&parent.getLeft()==node){
                parent.setLeft(right);
            }
            else{
                parent.setRight(right);
            }
            right.setParent(parent);

        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if(right.getLeft()!=null){
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    private void setRed(RBTreeNode node) {
    }

    private void setBlack(RBTreeNode node) {
    }


}
