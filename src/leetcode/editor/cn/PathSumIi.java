package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
public class PathSumIi {
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
class Solution_113 {
    List<List<Integer>> resultList = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return resultList;
        }
        hasPathSum(root, targetSum);
        return resultList;

    }

    public void hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            resultList.add(new LinkedList<Integer>(path));
        }
        hasPathSum(root.left, targetSum);
        hasPathSum(root.right, targetSum);
        path.pollLast();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
