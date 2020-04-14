package Explore.linkedlist;

/**
 * 设计链表
 */

public class Solution_1 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    class MyLinkedList {
        ListNode dummy;  // 哨兵结点
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            dummy = new ListNode(0);
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;
            ListNode cur = dummy.next;
            for (int i = 0; i < index; i++)
                cur = cur.next;
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size || index < 0)
                return;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            // 找到第i个结点
            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = cur;
            pre.next = newNode;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            size--;
        }
    }
}
