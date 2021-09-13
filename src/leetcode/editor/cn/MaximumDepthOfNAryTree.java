package leetcode.editor.cn;

import java.util.List;

//Java：N 叉树的最大深度
public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.


class Solution_559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildLength = 0;
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            maxChildLength = Math.max(maxChildLength, maxDepth(children.get(i)));
        }
        return maxChildLength + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
