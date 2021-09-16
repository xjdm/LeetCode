package leetcode.editor.cn;
//Java：路径总和
public class PathSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return targetSum-root.val==0;
        }
        boolean leftHasPathSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightHashPathSum = hasPathSum(root.right, targetSum - root.val);
        return  leftHasPathSum || rightHashPathSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
