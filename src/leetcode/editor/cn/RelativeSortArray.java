package leetcode.editor.cn;

import java.util.*;

//Java：数组的相对排序
public class RelativeSortArray {
    public static void main(String[] args) {
        Solution1122 solution = new Solution1122();
        int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19, 5}, arr2[] = {2, 1, 4, 3, 9, 6};
        // TO TEST
        solution.relativeSortArray(arr1, arr2);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap();
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (map.get(arr1[j]) == null) {
                    if (map.get(arr1[i]) == null) {
                        // 同时为空，交换
                        if (arr1[j] < arr1[i]) {
                            // 交换
                            int temp = arr1[i];
                            arr1[i] = arr1[j];
                            arr1[j] = temp;
                        }
                    }
                    continue;
                }
                // j不为空，i为空或者位置小，交换
                if (map.get(arr1[i]) == null || map.get(arr1[i]) > map.get(arr1[j])) {
                    // 交换
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        return arr1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
