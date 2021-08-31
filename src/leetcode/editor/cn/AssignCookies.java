package leetcode.editor.cn;

import java.util.Arrays;

//Java：分发饼干
public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childCount = 0;
        int cookieCount = 0;
        while (childCount < g.length && cookieCount < s.length) {
            if (s[cookieCount] >= g[childCount]) {
                childCount++;
            }
            cookieCount++;
        }
        return childCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
