package com.idstaa.lg.stage5;

/**
 * @author chenjie
 * @date 2021/1/12 0:22
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 在此处写入代码
        if(head==null) return null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode!=null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode){
                slowNode = head;//慢指针回到链表头部
                while(fastNode != slowNode){
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;//快指针也调整为一次走一步
                }
                return fastNode;
            }
        }
        return null;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    ListNode() {
        val = x;
        next = null;
    }
}
