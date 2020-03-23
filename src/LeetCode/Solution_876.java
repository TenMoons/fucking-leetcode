package LeetCode;

/**
 * 876.链表的中间结点
 */

public class Solution_876 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
