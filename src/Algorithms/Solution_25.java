package Algorithms;

public class Solution_25 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode lo, hi;
        lo = hi = head;
        // 找到长度为k的一组子链表
        for (int i = 0; i < k; i++) {
            // 剩余元素不足k个保持原样
            if (hi == null)
                return head;
            hi = hi.next;
        }
        ListNode newHead = reverse(lo, hi);
        // 和剩余部分连接
        lo.next = reverseKGroup(hi, k);
        return newHead;
    }

    // 翻转以head为头结点，以tail为尾结点的链表(不包括tail)，并返回新的头结点
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
