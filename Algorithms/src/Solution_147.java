/**
 * 147. 对链表进行插入排序
 */

public class Solution_147 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val > head.next.val) {  // 需要排序
                ListNode cur = head.next;  // 需要插入的节点
                pre = dummy;
                while (pre.next.val < cur.val)   // 查找插入位置
                    pre = pre.next;
                // 重新链接指针关系
                head.next = cur.next;
                // 在pre和pre.next之间插入cur节点
                cur.next = pre.next;
                pre.next = cur;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
