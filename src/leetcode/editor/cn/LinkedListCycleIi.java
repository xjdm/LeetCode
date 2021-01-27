package leetcode.editor.cn;

//Java：环形链表 II
public class LinkedListCycleIi{
    public static void main(String[] args) {
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class P142Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;//快指针走两步
            slow = slow.next;//慢指针走一步
            if(fast == slow)  break; //相遇代表有环
        }
        if(fast == null || fast.next == null)return null;
        slow = head;//慢指针回到链表头部
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;//快指针也调整为一次走一步
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
