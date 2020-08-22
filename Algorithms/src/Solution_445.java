/**
 * 445. 两数相加 II
 */

public class Solution_445 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder op1 = new StringBuilder();
        StringBuilder op2 = new StringBuilder();
        while (l1 != null) {
            op1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            op2.append(l2.val);
            l2 = l2.next;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = op1.length() - 1, j = op2.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int num = op1.charAt(i) - '0' + op2.charAt(j) - '0' + carry;
            res.append(num % 10);
            carry = num / 10;
        }
        // l1位数更多
        while (i >= 0) {
            int num = op1.charAt(i--) - '0' + carry;
            res.append(num % 10);
            carry = num / 10;
        }
        // l2位数更多
        while (j >= 0) {
            int num = op2.charAt(j--) - '0' + carry;
            res.append(num % 10);
            carry = num / 10;
        }
        // 最高位进位
        if (carry != 0)
            res.append(carry);
        // 头插法构建新链表
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        i = 0;
        while (i < res.length()) {
            ListNode cur = new ListNode(res.charAt(i++) - '0');
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}
