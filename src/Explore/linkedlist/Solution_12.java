package Explore.linkedlist;

/**
 * 扁平化多级双向链表
 */

public class Solution_12 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    private Node dummy = new Node();

    public Node flatten(Node head) {
        if (head == null)
            return null;
        insert(head);
        // 取消哨兵结点与头结点的链接关系
        head.prev = null;
        dummy.next = null;
        return head;
    }

    private void insert(Node cur) {
        if (cur == null)
            return;
        insert(cur.next);
        insert(cur.child);

        cur.prev = dummy;
        cur.next = dummy.next;
        if (dummy.next != null) {
            dummy.next.prev = cur;
        }
        dummy.next = cur;
        cur.child = null;
    }
}
