package leetcode.editor.cn;

//Java：二叉搜索子树的最大键值和
public class MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_1373 {
    private int max;
    public int maxSumBST(TreeNode root) {
        // 后续遍历 判断是否是二叉搜索树,并求值
        traverse(root);
        return max;
    }

    private Result traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        Result leftResult = traverse(root.left);
        Result rightResult = traverse(root.right);
        if (leftResult != null && (!leftResult.isBst || leftResult.max >= root.val)) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        }
        if (rightResult != null && (!rightResult.isBst || rightResult.min <= root.val)) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
        }
        int nSum = leftResult == null ? 0 : leftResult.nSum;
        nSum += rightResult == null ? 0 : rightResult.nSum;
        nSum += root.val;
        int minVal = leftResult == null ? root.val : leftResult.min;
        int maxVal = rightResult == null ? root.val : rightResult.max;
        this.max = Math.max(this.max, nSum);
        return new Result(minVal, maxVal, nSum, true);
    }

    class Result {
        private int min;
        private int max;
        int nSum;
        boolean isBst;

        public Result(int min, int max, int nSum, boolean isBst) {
            this.min = min;
            this.max = max;
            this.nSum = nSum;
            this.isBst = isBst;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
