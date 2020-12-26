package leetcode.editor.cn;

import java.util.List;

//Java：两数相加
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers{
    public static void main(String[] args) {
        P2Solution solution = new P2Solution();
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        while (listNode!=null){
            System.out.printf(listNode.val+" ");
            listNode = listNode.next;
        }

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class P2Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1 ,q=l2;
        ListNode resultHead = new ListNode(-1);
        ListNode curr = resultHead;

        // 进位
        int carry = 0;
        // 遍历两个链表
        while(p!=null || q!=null){
            int x = p!=null ?p.val : 0;
            int y = q!=null ?q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            int num = sum % 10;
            curr.next = new ListNode(num);
            curr = curr.next;

            p=p==null ?p:p.next;
            q=q==null ?q:q.next;
        }
        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return resultHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
