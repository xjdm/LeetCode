package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的右视图
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution_199 solution = new Solution_199();
        // TO TEST
        TreeNode root = new TreeNode(1);
        TreeNode left4 = new TreeNode(4,null,null);
        TreeNode left5 = new TreeNode(5,null,left4);
        TreeNode left2 = new TreeNode(2,null,left5);
        TreeNode left3 = new TreeNode(3,null,null);
        root.left = new TreeNode(1,left2,left3);
        List<Integer> integers = solution.rightSideView(root);
        System.out.println(integers);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)


class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if (i == size - 1) {
                    list.add(curNode.val);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
