package Explore.linkedlist;

/**
 * 移除链表元素
 */

public class Solution_7 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }
}
