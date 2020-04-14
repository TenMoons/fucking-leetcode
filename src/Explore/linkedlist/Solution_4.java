package Explore.linkedlist;

/**
 * 相交链表
 */

public class Solution_4 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int len = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) {
            len++;
            pA = pA.next;
        }
        while (pB.next != null) {
            len--;
            pB = pB.next;
        }
        if (pA != pB)
            return null;
        // pA指向表更长的表头
        pA = len > 0 ? headA : headB;
        pB = pA == headA ? headB : headA;
        len = Math.abs(len);
        while (len-- != 0)
            pA = pA.next;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
