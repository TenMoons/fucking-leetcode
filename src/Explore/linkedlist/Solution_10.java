package Explore.linkedlist;

/**
 * 合并两个有序链表
 */

public class Solution_10 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  // 哨兵节点
        ListNode p = new ListNode(0);
        dummy.next = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return dummy.next.next;
    }
}
