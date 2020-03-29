package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 */

public class Solution_590 {
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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res){
        if (root == null)
            return;
        for (Node item : root.children){
            postOrder(item, res);
        }
        res.add(root.val);
    }
}
