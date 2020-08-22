import java.util.ArrayList;

/**
 * 面试题06. 从尾到头打印链表
 */

public class Solution_6 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[res.length - i] = list.get(i);
        return res;
    }
}
