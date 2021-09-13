package leetcode.editor.cn;

//Java：二叉树的镜像
public class ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_JZ27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root!=null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right =temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
