package linkedlist;

/**
 * 反转链表
 */

public class Solution_6 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;  // 修改方向
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }

}
