package leetcode.editor.cn;

import com.idstaa.lg.stage5.Solution;

//Java：删除排序链表中的重复元素
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class P83Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode target = head;
        ListNode curr = head;
        ListNode resultNode = target;
        while (curr != null) {
            if (target.val != curr.val) {
                // 不相等，就移动
                target.next = curr;
                target = target.next;
            }
            curr = curr.next;
        }
        if (target.next != null) {
            target.next = null;
        }
        return resultNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
