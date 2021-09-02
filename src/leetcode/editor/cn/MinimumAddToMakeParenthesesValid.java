package leetcode.editor.cn;

//Java：使括号有效的最少添加
public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Solution_921 solution = new Solution_921();
        // TO TEST
        int i = solution.minAddToMakeValid("()))((");
        System.out.println(i);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_921 {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号时候开始计时
                leftCount++;
                count++;
            } else {
                // 发现右括号且有左括号匹配，则计时-1;左括号-1
                if (leftCount > 0) {
                    count--;
                    leftCount--;
                } else {
                    count++;
                    leftCount = 0;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
