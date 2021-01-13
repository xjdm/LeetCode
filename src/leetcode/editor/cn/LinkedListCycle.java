package leetcode.editor.cn;
//Java：环形链表
public class LinkedListCycle{
    public static void main(String[] args) {}
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
class P141Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while(fastNode!=null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
