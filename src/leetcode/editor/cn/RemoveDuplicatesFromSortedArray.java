package leetcode.editor.cn;

//Java：删除排序数组中的重复项
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class P26Solution {
    public int removeDuplicates(int[] nums) {
        // 1、定义两个指针（索引）分别指向目标位和待移动元素位
        int target = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[target] != nums[i]) {
                // 不相等，则把目标位置后移
                if (++target != i) {
                    nums[target] = nums[i];
                }
            }
        }
        return target + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
