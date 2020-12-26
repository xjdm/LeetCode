package leetcode.editor.cn;

import java.util.Stack;

//Java：两数相加 II
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        P445StackSolution solution = new P445StackSolution();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
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
        if(carry==1){
            ListNode n = new ListNode(1);
            n.next = res;
            res = n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
