package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

//Java：按奇偶排序数组 II
public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution922 solution = new Solution922();
        int arr[] = {3, 1, 6, 8};
        // TO TEST
        solution.sortArrayByParityII(arr);

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;//偶数下标
        int odd = 1;//奇数下标
        int[] arr = new int[A.length];
        for (int a : A) {
            if (a % 2 == 0) {//如果为偶数
                arr[even] = a;
                even+=2;
            } else {//如果为奇数
                arr[odd] = a;
                odd+=2;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
