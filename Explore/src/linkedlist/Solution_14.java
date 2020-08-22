package linkedlist;

/**
 * 旋转链表
 */

public class Solution_14 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = head;
        int len = 0;
        while (fast!= null) {
            len++;
            fast = fast.next;
        }
        k = k % len;
        if (k == 0)
            return head;
        fast = head;
        while (k-- > 0)
            fast = fast.next;
        // 找到倒数第k+1个节点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 倒数第k个节点
        ListNode latter = slow.next;
        slow.next = null;
        fast.next = head;
        return latter;
    }
}
