package leetcode.editor.cn;

import java.util.List;

//Java：删除排序链表中的重复元素 II
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.deleteDuplicates(new ListNode(3, new ListNode(3, new ListNode(3, null))));
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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode pre = head; // 上一个节点
        ListNode preNewNode = null;// 上一个有效节点
        ListNode curr = head.next;
        ListNode result = null;
        boolean preNeedDelete = false;
        while (curr != null) {
            if (curr.val == pre.val) {
                preNeedDelete = true;
            } else {
                if (!preNeedDelete) { // 上个节点有效
                    if (result == null) {
                        preNewNode = pre;
                        result = preNewNode;
                    } else {
                        preNewNode.next = pre;
                        preNewNode = preNewNode.next;
                    }
                }
                preNeedDelete = false;
            }
            pre = curr; // 上一个节点改成当前节点
            curr = curr.next;
        }
        if (!preNeedDelete) { // 最后一个节点有效
            if (result == null) {
                preNewNode = pre;
                result = preNewNode;
            } else {
                preNewNode.next = pre;
            }
        } else {
            if (preNewNode != null) {
                preNewNode.next = null;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
