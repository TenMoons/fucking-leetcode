package LeetCode;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */

public class Solution_116 {
    class Node {
        public int val;
        public Node left, right, next;

        public Node(int _val) {
            this.val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null)
            return root;
        Node pre = root;
        // BFS
        while(pre.left != null) {
            Node tmp = pre;
            // 遍历当前层，完成下一层的next链接
            while (tmp != null) {
                // 完成左孩子的next
                tmp.left.next = tmp.right;
                // tmp的parent已完成tmp的next，则可以通过parent完成右孩子的right
                if (tmp.next != null)
                    tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            pre = pre.left;  // 下一层
        }
        return root;
    }
}
