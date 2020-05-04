package LCOF;

/**
 * 面试题25. 合并两个排序的链表
 */

public class Solution_25 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        if (cur1 == null && cur2 == null)
            return null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return dummy.next;
    }
}
