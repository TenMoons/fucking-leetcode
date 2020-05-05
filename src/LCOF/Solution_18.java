package LCOF;

/**
 * 面试题18. 删除链表的节点
 */

public class Solution_18 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
