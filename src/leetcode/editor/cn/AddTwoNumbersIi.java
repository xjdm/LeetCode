package leetcode.editor.cn;

import java.util.Stack;

//Java：两数相加 II
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        P445Solution solution = new P445Solution();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(2,new ListNode(6));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class P445Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = l1;
        ListNode r2 = l2;
        int len1 = getListNodeLength(l1);
        int len2 = getListNodeLength(l2);
        if (len2 == 0) {
            return l2;
        }
        if (len1 == 0) {
            return l1;
        }
        if (len1 < len2) {
            return alignWithCarry(l2,l1,len2,len1);
        } else {
            return alignWithCarry(l1,l2,len1,len2);
        }
    }

    private ListNode alignWithCarry(ListNode l1, ListNode l2, int len1, int len2) {
        ListNode head = l1;
        int carry = alignAdd(l1,l2,len1,len2);
        if (carry == 1) {
            head = l2;
            head.next = l1;
            head.val = carry;
        }
        return head;
    }

    private int alignAdd(ListNode l1, ListNode l2, int len1, int len2) {
        if (l1 == null && l2 == null) {
            return 0;
        }
        if (len1 > len2) {
            int carry = alignAdd(l1.next, l2, len1 - 1, len2);
            int val1 = l1.val;
            l1.val = (val1 + carry) % 10;
            carry = (val1 + carry) / 10;
            return carry;
        } else if (len1 == len2) {
            int carry = alignAdd(l1.next, l2.next, len1 - 1, len2 - 1);
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            return carry;
        } else {
            return 0;
        }

    }

    private int getListNodeLength(ListNode l1) {
        int length = 0;
        while (l1 != null) {
            length++;
            l1 = l1.next;
        }
        return length;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class P445StackSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int s1Num = s1.isEmpty() ? 0 : s1.pop();
            int s2Num = s2.isEmpty() ? 0 : s2.pop();
            int sum = s1Num + s2Num + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = res;
            res = n;
            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode n = new ListNode(1);
            n.next = res;
            res = n;
        }
        return res;
    }
}