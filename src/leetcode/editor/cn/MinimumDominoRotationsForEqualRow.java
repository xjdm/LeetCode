package leetcode.editor.cn;
//Java：行相等的最少多米诺旋转
public class MinimumDominoRotationsForEqualRow{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        // 记录1-6 数组分别在A，B中出现的次数以及在多米诺骨牌出现的次数
        int[] countA = new int[6];
        int[] countB = new int[6];
        int[] countAB = new int[6];
        for (int i = 0; i < n; i++) {
            countA[A[i] - 1]++;
            countB[B[i] - 1]++;
            countAB[A[i] - 1]++;
            if (A[i] != B[i]) {
                countAB[B[i] - 1]++;
            }
        }
        // 在所有在所有多米诺骨牌中出现的数字中寻找最小多米诺旋转次数
        int minRotations = -1;
        for (int i = 0; i < 6; i++) {
            if (countAB[i] == n) {
                minRotations = n - Math.max(countA[i], countB[i]);
                break;
            }
        }
        return minRotations;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
