package Algorithms;

/**
 * N叉树的前序遍历
 */

import java.util.ArrayList;
import java.util.List;

public class Solution_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /* 递归法 */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(Node root, List<Integer> res){
        if (root == null)
            return;
        res.add(root.val);
        for (Node item : root.children){
            preOrder(item, res);
        }
    }

}
