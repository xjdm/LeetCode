package leetcode.editor.cn;

import java.util.Arrays;

//Java：用最少数量的箭引爆气球
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        // 排序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 1;
        int maxRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > maxRight) {
                count++;
                maxRight = points[i][1];
            } else {
                maxRight = Math.min(points[i][1],maxRight);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
