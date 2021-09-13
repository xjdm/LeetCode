package leetcode.editor.cn;

//Java：二叉树的最大深度
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

class Solution_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return Math.max(maxLeftDepth, maxRightDepth)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
