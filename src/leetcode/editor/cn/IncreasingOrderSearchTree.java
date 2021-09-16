package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：递增顺序搜索树
public class IncreasingOrderSearchTree{
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
class Solution_897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        // 中序遍历
        innerOrder(root,resultList);
        // 重新生成一棵树
        TreeNode resultNode = new TreeNode(-1);
        TreeNode headNode = resultNode;
        for (int i = 0; i < resultList.size(); i++) {
            TreeNode newNode  = new TreeNode();
            newNode.val = resultList.get(i).intValue();
            headNode.right = newNode;
            headNode = headNode.right;
        }
        return resultNode.right;
    }

    public void innerOrder(TreeNode root,List<Integer> resultList){
        if(root==null){
           return ;
        }
        innerOrder(root.left,resultList);
        resultList.add(root.val);
        innerOrder(root.right,resultList);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
