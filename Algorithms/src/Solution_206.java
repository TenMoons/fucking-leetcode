public class Solution_206 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
