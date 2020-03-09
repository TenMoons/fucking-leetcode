package LeetCode;

public class Solution_234 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        boolean flag = true;
        if (head == null || head.next == null) {
            return true;
        }

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;  // 右边的第一个结点
        ListNode n;
        slow.next = null;
        // 修改链表结构
        while(fast != null){
            n = fast.next;
            fast.next = slow;
            slow = fast;
            fast = n;
        }
        n = slow; // 记录表尾
        fast = head;
        // 判断是否是回文
        while(fast != null && slow != null){
            if(fast.val != slow.val){
                flag = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        // 恢复链表结构
        slow = n.next;
        n.next = null;
        while(slow != null){
            fast = slow.next;
            slow.next = n;
            n = slow;
            slow = fast;
        }
        return flag;
    }
}
