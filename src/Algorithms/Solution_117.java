package Algorithms;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */

public class Solution_117 {
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
        if (root == null || root.left == null && root.right == null)
            return root;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNext(root);
        }
        if (root.left == null)
            root.right.next = getNext(root);
        if (root.right == null)
            root.left.next = getNext(root);
        // 先递归右子树形成右子树的next关系，左子树的next才能够正确链接
        connect(root.right);
        connect(root.left);

        return root;
    }

    // 通过当前节点的parent找其next的节点
    private Node getNext(Node root) {
        while (root.next != null) {
            if (root.next.left != null)
                return root.next.left;
            if (root.next.right != null)
                return root.next.right;
            root = root.next;
        }
        return null;
    }
}
