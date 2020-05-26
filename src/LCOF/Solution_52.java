package LCOF;

/**
 * 面试题 52. 两个链表的第一个公共节点
 */

public class Solution_52 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        int n = 0;
        // 计算A表长度
        while (curA != null) {
            n++;
            curA = curA.next;
        }
        // 与B的长度比较
        while (curB != null) {
            n--;
            curB = curB.next;
        }
        curA = n > 0 ? headA : headB;
        curB = curA == headA ? headB : headA;
        n = Math.abs(n);
        while (n > 0) {
            n--;
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
