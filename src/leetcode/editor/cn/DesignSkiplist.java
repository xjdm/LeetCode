package leetcode.editor.cn;

import java.util.Random;

//Java：设计跳表
public class DesignSkiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.search(0); // 返回 false
        skiplist.add(4);
        skiplist.search(1); // 返回 true
        skiplist.erase(0); // 返回 false，0 不在跳表中
        skiplist.erase(1); // 返回 true
        skiplist.search(1); // 返回 false，1 已被擦除
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Skiplist {
    class Node {
        int val;
        Node right, down;

        public Node(int val) {
            this(val, null, null);
        }

        public Node(int val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }

    int HEAD_VALUE = -1;
    final Node HEAD = new Node(HEAD_VALUE);
    Node head;// 最左上角的头结点，所有操作开始的位置
    int levels;
    int length;

    public Skiplist() {
        head = HEAD;
        levels = 1;
        length = 0;
    }

    public boolean search(int target) {
        Node node = head;
        while (node != null) {
            // 1、在同一层查找，直到找到，或者到链表结尾为空
            while (node.right != null && node.right.val < target) {
                node = node.right;
            }
            // 2、若找到，返回true
            Node right = node.right;
            if (right != null && right.val == target) {
                return true;
            } else {
                // 3、若右层数据较大，向下一层查找
                node = node.down;
            }
        }
        return false;
    }

    public void add(int num) {
        // 1.定位插入位置：原链表中 >= num 的最小节点前
        Node node = head;
        Node[] nodes = new Node[levels];
        int i = 0 ;// 操作上述数组
        while (node != null) {
            // 1、在同一层查找，直到找到，或者到链表结尾为空
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            // 右侧为结尾 或者 右侧值大 或者 右侧值相同
            nodes[i++] = node;
            // 继续查找下一层位置
            node = node.down;
        }
        // 2、插入新节点
        // 要插入节点的上一节点
        node =nodes[--i];
        Node newNode = new Node(num,node.right,null);
        node.right = newNode;
        // 3、根据扔硬币决定（是否）生成所有
        addIndicesByCoinFlip(newNode,nodes,i);
        length++;
    }

    private void addIndicesByCoinFlip(Node node, Node[] nodes, int i) {
        Node downNode = node;
        Random random = new Random();
        int coins = random.nextInt(2);
        while(coins==1 && levels<(length>>6)){
            if(i>0){
                Node pre = nodes[--i];
                Node newNode = new Node(node.val,pre.right,downNode);
                pre.right = newNode;
                downNode = newNode;
                coins = random.nextInt(2);
            }else {
                Node newIndex = new Node(node.val,null,downNode);
                Node newHead = new Node(HEAD_VALUE,newIndex,head);
                head = newHead;
                levels++;
            }
        }
    }

    public boolean erase(int num) {
        boolean exist = false;
        Node node = head;
        // 1、获取该指定数据节点的前一个节点
        while (node != null) {
            // 1、在同一层查找，直到找到，或者到链表结尾为空
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            // 2、与当前层链表断开
            Node right = node.right;
            if (right != null && right.val == num) {
                node.right = right.right;
                right.right = null;
                exist = true;
            }
            // 3、删除下一层
            node = node.down;
        }
        if(exist){
            length--;
        }
        return  exist;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)
