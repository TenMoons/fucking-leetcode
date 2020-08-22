public class Solution_160 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int n = 0;  // 链表长度差
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        // 定位长链表
        cur1 = n > 0 ? headA : headB;  // 较长链表的头结点
        cur2 = cur1 == headA ? headB : headA;  // 较短链表的头结点
        n = Math.abs(n);
        // 长链表指针先走n步
        while(n-- > 0){
            cur1 = cur1.next;
        }
        // 同步前进
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
