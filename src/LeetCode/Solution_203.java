package LeetCode;

public class Solution_203 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        // 哨兵结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return dummy.next;

        // 递归
        // if(head == null)
        // 	return null;

        // head.next = removeElements(head.next, val);
        // return head.val == val ? head.next : head;
    }
}
