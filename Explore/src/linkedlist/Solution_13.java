package linkedlist;

import java.util.HashMap;

/**
 * 复制带随机指针的列表
 */

public class Solution_13 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        // 原节点与拷贝节点的映射关系
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node clone = new Node(cur.val);
            map.put(cur, clone);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // 构造next映射
            map.get(cur).next = map.get(cur.next);
            // 构造random映射
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // 原地深拷贝
    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        // 将拷贝节点插入原节点之后
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 处理random
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null :cur.random.next;
            cur = cur.next.next;
        }
        // 分离原链表head和拷贝链表head.next
        cur = head;
        Node copyHead = head.next;
        while (cur.next != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return copyHead;
    }
}
