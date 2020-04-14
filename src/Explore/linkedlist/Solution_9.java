package Explore.linkedlist;

/**
 * 回文链表
 */

public class Solution_9 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next;
        // slow找到链表中点
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转后半段链表
        fast = slow.next;
        slow.next = null;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        // 表尾
        ListNode tail = slow;
        fast = head;
        // 从两端向中间依次比较
        while (fast != null && slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
